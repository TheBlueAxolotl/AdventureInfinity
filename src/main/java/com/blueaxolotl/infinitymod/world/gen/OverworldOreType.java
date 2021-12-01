package com.blueaxolotl.infinitymod.world.gen;

import com.blueaxolotl.infinitymod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OverworldOreType {

    TANZANITE(Lazy.of(ModBlocks.TANZANITE_ORE), 4, 4, 11);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    OverworldOreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }


    public static OverworldOreType get(Block block) {
        for (OverworldOreType ore : values()) {
            if(block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}
