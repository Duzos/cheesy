package com.duzo.cheesy.entity;

import com.duzo.cheesy.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class CheeseProjectile extends ThrowableItemProjectile {
    public CheeseProjectile(EntityType<? extends CheeseProjectile> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }

    public CheeseProjectile(LivingEntity p_36718_, Level p_36719_) {
        super(ModEntities.CHEESE_PROJECTILE.get(), p_36718_, p_36719_);
    }

    @Override
    protected void onHit(HitResult result) {
        if (!this.level().isClientSide) {
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z, 50f, Level.ExplosionInteraction.BLOCK);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return ModItems.CHEESE.get();
    }
}
