package com.blueaxolotl.infinitymod.client.model;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.entities.AcceleratedProtectorEntity;
import com.blueaxolotl.infinitymod.entities.PixieEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AcceleratedProtectorModel extends AnimatedGeoModel<AcceleratedProtectorEntity> {
    @Override
    public ResourceLocation getModelLocation(AcceleratedProtectorEntity entity)
    {
        return new ResourceLocation(InfinityMod.MOD_ID, "geo/accelerated_protector.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(AcceleratedProtectorEntity entity)
    {
        return new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/accelerated_protector.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AcceleratedProtectorEntity entity)
    {
        return new ResourceLocation(InfinityMod.MOD_ID, "animations/accelerated.animations.json");
    }
}
