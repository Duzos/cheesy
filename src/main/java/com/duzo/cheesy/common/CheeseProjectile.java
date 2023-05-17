package com.duzo.cheesy.common;

import com.duzo.cheesy.Cheesy;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class CheeseProjectile extends AbstractArrow {
    public CheeseProjectile(EntityType<? extends AbstractArrow> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public CheeseProjectile(LivingEntity p_36718_, Level p_36719_) {
        super(Cheesy.CHEESE_PROJECTILE.get(), p_36718_, p_36719_);
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }

    @Override
    protected void onHit(HitResult result) {
        this.level.explode(this,result.getLocation().x,result.getLocation().y,result.getLocation().z,5f, Level.ExplosionInteraction.BLOCK);
        this.remove(RemovalReason.DISCARDED);
    }
}
