package com.blueaxolotl.infinitymod.client.render;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.client.model.SharkModel;
import com.blueaxolotl.infinitymod.client.model.SnakeModel;
import com.blueaxolotl.infinitymod.entities.SharkEntity;
import com.blueaxolotl.infinitymod.entities.snakeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SharkRenderer  extends MobRenderer<SharkEntity, SharkModel<SharkEntity>> {
    protected static final ResourceLocation TEXTURE2 = new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/shark.png");

    public SharkRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SharkModel<>(), 0.4f);
    }

    @Override
    public ResourceLocation getEntityTexture(SharkEntity entity) {
        return TEXTURE2;
    }

}
