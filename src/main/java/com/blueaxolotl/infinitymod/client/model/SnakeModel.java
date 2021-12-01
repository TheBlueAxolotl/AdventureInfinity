package com.blueaxolotl.infinitymod.client.model;

import com.blueaxolotl.infinitymod.entities.snakeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.swing.text.html.parser.Entity;


public class SnakeModel <T extends snakeEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer lowerBody;
    private final ModelRenderer upperBody;
    private final ModelRenderer cube_r2;

    public SnakeModel() {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(-1.5F, 22.0F, -7.0F);
        setRotationAngle(head, 0.0F, -0.0436F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-0.0867F, 0.0F, 0.279F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.0436F, 0.0F);
        cube_r1.setTextureOffset(0, 0).addBox(-2.5F, -2.0F, -4.0F, 5.0F, 4.0F, 4.0F, 0.0F, true);

        lowerBody = new ModelRenderer(this);
        lowerBody.setRotationPoint(-1.6F, 22.5F, 1.0F);
        setRotationAngle(lowerBody, 0.0F, 0.0F, 0.0F);
        lowerBody.setTextureOffset(10, 11).addBox(-1.4F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
        lowerBody.setTextureOffset(0, 8).addBox(-1.4F, -1.5F, 4.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

        upperBody = new ModelRenderer(this);
        upperBody.setRotationPoint(-1.5F, 22.5F, 1.0F);
        setRotationAngle(upperBody, 0.0038F, -0.0002F, -0.0001F);
        upperBody.setTextureOffset(14, 4).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(1.5F, 1.5F, -1.0F);
        upperBody.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.0F, 0.0F);
        cube_r2.setTextureOffset(0, 15).addBox(-3.0F, -3.0F, -7.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        lowerBody.render(matrixStack, buffer, packedLight, packedOverlay);
        upperBody.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}


