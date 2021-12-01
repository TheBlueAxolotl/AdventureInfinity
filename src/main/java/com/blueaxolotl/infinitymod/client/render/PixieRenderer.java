package com.blueaxolotl.infinitymod.client.render;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.client.model.PixieModel;
import com.blueaxolotl.infinitymod.client.model.ProtectorModel;
import com.blueaxolotl.infinitymod.entities.PixieEntity;
import com.blueaxolotl.infinitymod.entities.ProtectorEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PixieRenderer extends GeoEntityRenderer<PixieEntity> {

    protected static final ResourceLocation TEXTURE40212 = new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/pixie.png");

    public PixieRenderer(EntityRendererManager renderManager) {
        super(renderManager, new PixieModel());
        this.shadowSize = 0.4F;
    }

    @Override
    public ResourceLocation getEntityTexture(PixieEntity entity) {
        return TEXTURE40212;
    }
}
