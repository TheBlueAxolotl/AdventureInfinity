package com.blueaxolotl.infinitymod.entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityPosWrapper;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.Random;

public class PixieEntity extends BatEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public PixieEntity(EntityType<? extends BatEntity> type, World worldIn)
    {
        super(type, worldIn);
        this.ignoreFrustumCheck = true;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 1.0D)
                .createMutableAttribute(Attributes.FLYING_SPEED, 0.05D);

    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new SwimGoal(this));
        this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
    }
    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Nullable
    @Override
    protected net.minecraft.util.SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    @Nullable
    @Override
    protected net.minecraft.util.SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_BAT_HURT;
    }


    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pixie.fly", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.pixie.idle", true));
        }
        return PlayState.CONTINUE;
    }



    @Override
    public void registerControllers(AnimationData data)
    {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory()
    {
        return this.factory;
    }
}
