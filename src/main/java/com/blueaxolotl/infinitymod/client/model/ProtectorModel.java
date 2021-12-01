package com.blueaxolotl.infinitymod.client.model;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.entities.ProtectorEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ProtectorModel extends AnimatedGeoModel<ProtectorEntity>{
    @Override
    public ResourceLocation getModelLocation(ProtectorEntity entity)
    {
        return new ResourceLocation(InfinityMod.MOD_ID, "geo/protector.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ProtectorEntity entity)
    {
        return new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/protector.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ProtectorEntity entity)
    {
        return new ResourceLocation(InfinityMod.MOD_ID, "animations/protector.animations.json");
    }

}
