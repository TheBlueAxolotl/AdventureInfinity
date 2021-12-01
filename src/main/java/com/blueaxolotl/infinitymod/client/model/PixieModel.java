package com.blueaxolotl.infinitymod.client.model;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.entities.PixieEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PixieModel extends AnimatedGeoModel<PixieEntity> {
        @Override
        public ResourceLocation getModelLocation(PixieEntity entity)
        {
            return new ResourceLocation(InfinityMod.MOD_ID, "geo/pixie.geo.json");
        }

        @Override
        public ResourceLocation getTextureLocation(PixieEntity entity)
        {
            return new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/pixie.png");
        }

        @Override
        public ResourceLocation getAnimationFileLocation(PixieEntity entity)
        {
            return new ResourceLocation(InfinityMod.MOD_ID, "animations/pixie.animations.json");
        }
}
