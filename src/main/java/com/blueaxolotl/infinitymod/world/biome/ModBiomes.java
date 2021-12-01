package com.blueaxolotl.infinitymod.world.biome;

import com.blueaxolotl.infinitymod.InfinityMod;
import net.minecraft.client.audio.BackgroundMusicTracks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES
            = DeferredRegister.create(ForgeRegistries.BIOMES, InfinityMod.MOD_ID);

    public static RegistryKey<Biome> SLEEPY_BIOME = registerBiome("sleepybiome");
    public static RegistryKey<Biome> SLEEPY_MOUNTAINS = registerBiome("sleepymountainbiome");

    public static RegistryKey<Biome> registerBiome(String biomeName) {
        BIOMES.register(biomeName, BiomeMaker::makeVoidBiome);
        return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(InfinityMod.MOD_ID, biomeName));
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
    }
}
