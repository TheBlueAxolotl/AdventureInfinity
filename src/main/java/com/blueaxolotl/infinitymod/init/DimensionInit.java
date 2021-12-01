package com.blueaxolotl.infinitymod.init;

import com.blueaxolotl.infinitymod.InfinityMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;

public class DimensionInit {
    public static RegistryKey<World> DreamDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(InfinityMod.MOD_ID, "dream_dimension"));
}
