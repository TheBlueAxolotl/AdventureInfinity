package com.blueaxolotl.infinitymod.client.render;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.client.model.SnakeModel;
import com.blueaxolotl.infinitymod.entities.snakeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SnakeRenderer extends MobRenderer<snakeEntity, SnakeModel<snakeEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(InfinityMod.MOD_ID, "textures/entity/snake.png");

    public SnakeRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SnakeModel<>(), 0.4f);
    }

    @Override
    public ResourceLocation getEntityTexture(snakeEntity entity) {
        return TEXTURE;
    }
}
