package com.blueaxolotl.infinitymod.entities;

import com.blueaxolotl.infinitymod.InfinityMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, InfinityMod.MOD_ID);

    public static final RegistryObject<EntityType<snakeEntity>> SNAKE = ENTITY_TYPES.register("snake",
            () -> EntityType.Builder.create(snakeEntity::new, EntityClassification.CREATURE)
                    .size(0.5f, 0.5f)
                    .build(new ResourceLocation(InfinityMod.MOD_ID, "snake").toString()));

    public static final RegistryObject<EntityType<SharkEntity>> SHARK = ENTITY_TYPES.register("shark",
            () -> EntityType.Builder.create(SharkEntity::new, EntityClassification.WATER_CREATURE)
                    .size(1.0f, 1.0f)
                    .build(new ResourceLocation(InfinityMod.MOD_ID, "shark").toString()));

    public static final RegistryObject<EntityType<ProtectorEntity>> PROTECTOR = ENTITY_TYPES.register("protector",
            () -> EntityType.Builder.create(ProtectorEntity::new, EntityClassification.MONSTER)
                    .size(1.0f, 3.0f)
                    .build(new ResourceLocation(InfinityMod.MOD_ID, "protector").toString()));

    public static final RegistryObject<EntityType<PixieEntity>> PIXIE = ENTITY_TYPES.register("pixie",
            () -> EntityType.Builder.create(PixieEntity::new, EntityClassification.MONSTER)
                    .size(0.2f, 0.4f)
                    .build(new ResourceLocation(InfinityMod.MOD_ID, "pixie").toString()));

    public static final RegistryObject<EntityType<AcceleratedProtectorEntity>> ACCELERATED = ENTITY_TYPES.register("accelerated_protector",
            () -> EntityType.Builder.create(AcceleratedProtectorEntity::new, EntityClassification.MONSTER)
                    .size(3.2f, 3.0f)
                    .build(new ResourceLocation(InfinityMod.MOD_ID, "accelerated_protector").toString()));



}
