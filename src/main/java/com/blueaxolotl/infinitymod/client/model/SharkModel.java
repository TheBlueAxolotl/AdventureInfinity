package com.blueaxolotl.infinitymod.client.model;

import com.blueaxolotl.infinitymod.entities.SharkEntity;
import com.blueaxolotl.infinitymod.entities.snakeEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

import javax.swing.text.html.parser.Entity;

public class SharkModel <T extends SharkEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer bottomjaw;
    private final ModelRenderer topfin;
    private final ModelRenderer backfin;

    public SharkModel() {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-3.0F, -7.0F, -7.0F, 8.0F, 7.0F, 14.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 24.0F, 0.0F);
        head.setTextureOffset(0, 21).addBox(-3.0F, -8.0F, -18.0F, 8.0F, 4.0F, 11.0F, 0.0F, false);

        bottomjaw = new ModelRenderer(this);
        bottomjaw.setRotationPoint(0.0F, 24.0F, 0.0F);
        bottomjaw.setTextureOffset(27, 21).addBox(-3.0F, -3.0F, -16.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);

        topfin = new ModelRenderer(this);
        topfin.setRotationPoint(0.0F, 24.0F, 0.0F);
        topfin.setTextureOffset(0, 0).addBox(1.0F, -9.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        backfin = new ModelRenderer(this);
        backfin.setRotationPoint(0.0F, 24.0F, 0.0F);
        backfin.setTextureOffset(0, 0).addBox(0.0F, -6.0F, 7.0F, 2.0F, 3.0F, 6.0F, 0.0F, false);
        backfin.setTextureOffset(0, 0).addBox(0.0F, -8.0F, 13.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        bottomjaw.render(matrixStack, buffer, packedLight, packedOverlay);
        topfin.render(matrixStack, buffer, packedLight, packedOverlay);
        backfin.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
}}

