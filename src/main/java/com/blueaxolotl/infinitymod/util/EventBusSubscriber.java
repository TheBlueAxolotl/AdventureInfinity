package com.blueaxolotl.infinitymod.util;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.Item.custom.ModSpawnEggs;
import com.blueaxolotl.infinitymod.entities.*;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = InfinityMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EventBusSubscriber {
        @SubscribeEvent
        public static void addEntityAttributes(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.PROTECTOR.get(), ProtectorEntity.setCustomAttributes().create());
            event.put(ModEntityTypes.PIXIE.get(), PixieEntity.setCustomAttributes().create());
            event.put(ModEntityTypes.SNAKE.get(), snakeEntity.setCustomAttributes().create());
            event.put(ModEntityTypes.SHARK.get(), SharkEntity.setCustomAttributes().create());
            event.put(ModEntityTypes.ACCELERATED.get(), AcceleratedProtectorEntity.setCustomAttributes().create());
        }

        @SubscribeEvent
        public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
            ModSpawnEggs.initSpawnEggs();
        }
    }
