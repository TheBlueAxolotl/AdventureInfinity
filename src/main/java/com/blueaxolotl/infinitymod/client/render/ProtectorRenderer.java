package com.blueaxolotl.infinitymod.client.render;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.client.model.ProtectorModel;
import com.blueaxolotl.infinitymod.entities.ProtectorEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ProtectorRenderer extends GeoEntityRenderer<ProtectorEntity> {
    protected static final ResourceLocation TEXTURE41212 = new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/protector.png");
    public ProtectorRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new ProtectorModel());
        this.shadowSize = 0.7F;
    }

    @Override
    public ResourceLocation getEntityTexture(ProtectorEntity entity) {
        return TEXTURE41212;
    }
}
