package com.blueaxolotl.infinitymod.block;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.Item.ModItemGroup;
import com.blueaxolotl.infinitymod.Item.ModItems;
import com.blueaxolotl.infinitymod.Item.custom.ModSpawnEggs;
import com.blueaxolotl.infinitymod.block.custom.trees.PurpleHeart;
import com.blueaxolotl.infinitymod.entities.ModEntityTypes;
import com.blueaxolotl.infinitymod.init.DimensionInit;
import net.minecraft.advancements.criterion.ChanneledLightningTrigger;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityMod.MOD_ID);


    public static final RegistryObject<Block> MAGINITE_BLOCK = registerBlock("maginite_block",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
            .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> TANZANITE_ORE = registerBlock("tanzanite_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> MAGINITE_ORE = registerBlock("maginite_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(7f)));


    public static final RegistryObject<Block> SLEEPING_STONE = registerBlock("sleeping_stone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> SLEEPING_COBBLESTONE = registerBlock("sleeping_cobblestone",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(6f)));

    public static final RegistryObject<Block> SLEEPING_GRASS = registerBlock("sleeping_grass",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(2f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> SLEEPING_DIRT = registerBlock("sleeping_dirt",
            () -> new Block(AbstractBlock.Properties.create(Material.CLAY)
                    .harvestLevel(0).harvestTool(ToolType.SHOVEL).hardnessAndResistance(2f).sound(SoundType.GROUND)));

    public static final RegistryObject<Block> PURPLEHEART_LOG = registerBlock("purpleheart_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> PURPLEHEART_PLANKS = registerBlock("purpleheart_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> STRIPPED_PURPLEHEART_LOG = registerBlock("stripped_purpleheart_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_PURPLEHEART_WOOD = registerBlock("stripped_purpleheart_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> PURPLEHEART_WOOD = registerBlock("purpleheart_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> PURPLEHEART_LEAVES = registerBlock("purpleheart_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES)
                    .hardnessAndResistance(0.2f).tickRandomly().sound(SoundType.PLANT).notSolid()));

    public static final RegistryObject<Block> DREAM_TELEPORTER = registerBlock("dream_teleporter",
            () -> new PortalBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> PURPLEHEART_SAPLING = registerBlock("purpleheart_sapling",
            () -> new SaplingBlock(new PurpleHeart(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }



    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.INFINITY_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
