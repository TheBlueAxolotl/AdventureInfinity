package com.blueaxolotl.infinitymod.block;

import com.blueaxolotl.infinitymod.init.DimensionInit;
import com.blueaxolotl.infinitymod.world.dimension.DreamDimensionTeleporter;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class PortalBlock extends Block {
    public PortalBlock(Properties builder) {
        super(builder);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (!player.isCrouching()) {
                MinecraftServer server = worldIn.getServer();

                if (server != null) {
                    if (worldIn.getDimensionKey() == DimensionInit.DreamDim) {
                        ServerWorld overWorld = server.getWorld(World.OVERWORLD);
                        if (overWorld != null) {
                            player.changeDimension(overWorld, new DreamDimensionTeleporter(pos, false));
                        }
                    } else {
                        ServerWorld kjDim = server.getWorld(DimensionInit.DreamDim);
                        if (kjDim != null) {
                            player.changeDimension(kjDim, new DreamDimensionTeleporter(pos, true));
                        }
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }

        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
