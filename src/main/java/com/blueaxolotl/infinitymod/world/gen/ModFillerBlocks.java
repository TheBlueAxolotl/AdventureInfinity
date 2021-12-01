package com.blueaxolotl.infinitymod.world.gen;

import com.blueaxolotl.infinitymod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.TagMatchRuleTest;

public class ModFillerBlocks implements IFeatureConfig {
    public static final class ModFillerBlockTypes{
        public static final RuleTest SLEEPY_STONE = new BlockMatchRuleTest(ModBlocks.SLEEPING_STONE.get());
    }
}
