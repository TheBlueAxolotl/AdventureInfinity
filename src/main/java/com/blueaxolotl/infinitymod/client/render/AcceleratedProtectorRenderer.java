package com.blueaxolotl.infinitymod.client.render;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.client.model.AcceleratedProtectorModel;
import com.blueaxolotl.infinitymod.client.model.PixieModel;
import com.blueaxolotl.infinitymod.entities.AcceleratedProtectorEntity;
import com.blueaxolotl.infinitymod.entities.PixieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AcceleratedProtectorRenderer extends GeoEntityRenderer<AcceleratedProtectorEntity> {

    protected static final ResourceLocation TEXTURE40212 = new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/accelerated_protector.png");

    public AcceleratedProtectorRenderer(EntityRendererManager renderManager) {
        super(renderManager, new AcceleratedProtectorModel());
        this.shadowSize = 0.4F;
    }

    @Override
    public ResourceLocation getEntityTexture(AcceleratedProtectorEntity entity) {
        return TEXTURE40212;
    }
}
