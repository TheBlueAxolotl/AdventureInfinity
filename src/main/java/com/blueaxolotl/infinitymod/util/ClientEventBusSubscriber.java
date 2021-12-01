package com.blueaxolotl.infinitymod.util;


import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.client.render.*;
import com.blueaxolotl.infinitymod.entities.ModEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = InfinityMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SNAKE.get(), SnakeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.SHARK.get(), SharkRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PROTECTOR.get(), ProtectorRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PIXIE.get(), PixieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ACCELERATED.get(), AcceleratedProtectorRenderer::new);

    }
}
