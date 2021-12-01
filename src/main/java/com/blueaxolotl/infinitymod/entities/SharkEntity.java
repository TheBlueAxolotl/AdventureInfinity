package com.blueaxolotl.infinitymod.entities;

import com.blueaxolotl.infinitymod.InfinityMod;
import com.blueaxolotl.infinitymod.Item.ModItems;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.HashMap;

public class SharkEntity extends AbstractFishEntity {

    public static final Ingredient TEMPTATIION_ITEMS = Ingredient.fromItems(Items.TROPICAL_FISH);

    protected SharkEntity(EntityType<? extends AbstractFishEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 2.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new PanicGoal(this, 1));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1, TEMPTATIION_ITEMS, false));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(0, new FindWaterGoal(this));
        this.goalSelector.addGoal(0, new SwimGoal(this));

    }

    @Override
    protected ItemStack getFishBucket() {
        return null;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CREEPER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    @Nullable
    public SharkEntity createChild(ServerWorld world, AgeableEntity ageable) {
        return ModEntityTypes.SHARK.get().create(this.world);
    }
}
