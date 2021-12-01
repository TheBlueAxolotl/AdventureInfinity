package com.blueaxolotl.infinitymod.world.gen;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.entities.ModEntityTypes;
import com.blueaxolotl.infinitymod.world.biome.ModBiomes;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

public class ModEntityGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event) {
        addEntityToSpecificBiomes(event, ModEntityTypes.SNAKE.get(), 50, 1, 3,
                Biomes.FOREST, Biomes.BIRCH_FOREST);
        addEntityToSpecificBiomes(event, ModEntityTypes.PIXIE.get(), 40, 1, 3,
                ModBiomes.SLEEPY_MOUNTAINS);
        addEntityToSpecificBiomes(event, ModEntityTypes.PROTECTOR.get(), 30, 1, 2,
                ModBiomes.SLEEPY_MOUNTAINS);
        addEntityToSpecificBiomes(event, ModEntityTypes.ACCELERATED.get(), 10, 1, 2,
                ModBiomes.SLEEPY_MOUNTAINS);
    }

    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount, RegistryKey<Biome>... biomes) {
        // Goes through each entry in the biomes and sees if it matches the current biome we are loading
        boolean isBiomeSelected = Arrays.stream(biomes).map(RegistryKey::getLocation)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(isBiomeSelected) {
            addEntityToAllBiomes(event.getSpawns(), type, weight, minCount, maxCount);
        }
    }

    private static void addEntityToAllBiomes(MobSpawnInfoBuilder spawns, EntityType<?> type,
                                             int weight, int minCount, int maxCount) {
        List<MobSpawnInfo.Spawners> base = spawns.getSpawner(type.getClassification());
        base.add(new MobSpawnInfo.Spawners(type,weight, minCount, maxCount));
    }
}
