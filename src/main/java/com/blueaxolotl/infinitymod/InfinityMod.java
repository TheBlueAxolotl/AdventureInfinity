package com.blueaxolotl.infinitymod;

import com.blueaxolotl.infinitymod.Item.ModItems;
import com.blueaxolotl.infinitymod.block.ModBlocks;
import com.blueaxolotl.infinitymod.client.model.ProtectorModel;
import com.blueaxolotl.infinitymod.client.render.AcceleratedProtectorRenderer;
import com.blueaxolotl.infinitymod.client.render.PixieRenderer;
import com.blueaxolotl.infinitymod.client.render.ProtectorRenderer;
import com.blueaxolotl.infinitymod.entities.*;
import com.blueaxolotl.infinitymod.world.biome.ModBiomes;
import com.blueaxolotl.infinitymod.world.structure.ModStructures;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.GeckoLib;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(InfinityMod.MOD_ID)
public class InfinityMod
{
    public static final String MOD_ID = "infinitymod";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public InfinityMod() {
        GeckoLib.initialize();
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModEntityTypes.ENTITY_TYPES.register(eventBus);
        ModBiomes.register(eventBus);

        ModStructures.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderers(final FMLClientSetupEvent event)
    {
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.PIXIE.get(), PixieEntity.setCustomAttributes().create());
        });
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.PROTECTOR.get(), ProtectorEntity.setCustomAttributes().create());
        });
        EntitySpawnPlacementRegistry.register(ModEntityTypes.PIXIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canSpawnOn);

        EntitySpawnPlacementRegistry.register(ModEntityTypes.PROTECTOR.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canSpawnOn);

        EntitySpawnPlacementRegistry.register(ModEntityTypes.ACCELERATED.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canSpawnOn);
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.SNAKE.get(), snakeEntity.setCustomAttributes().create());
        });
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.SHARK.get(), SharkEntity.setCustomAttributes().create());
        });
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.ACCELERATED.get(), AcceleratedProtectorEntity.setCustomAttributes().create());
        });
        event.enqueueWork(() -> {
            ModStructures.setupStructures();
            AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
                    .put(ModBlocks.PURPLEHEART_LOG.get(), ModBlocks.STRIPPED_PURPLEHEART_LOG.get())
                    .put(ModBlocks.PURPLEHEART_WOOD.get(), ModBlocks.STRIPPED_PURPLEHEART_WOOD.get()).build();
        });

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            RenderTypeLookup.setRenderLayer(ModBlocks.PURPLEHEART_LEAVES.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.PURPLEHEART_SAPLING.get(), RenderType.getCutout());
        });
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PROTECTOR.get(), manager -> new ProtectorRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PIXIE.get(), manager -> new PixieRenderer(manager));
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ACCELERATED.get(), manager -> new AcceleratedProtectorRenderer(manager));
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}