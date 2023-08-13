package com.duzo.cheesy.common;

import com.duzo.cheesy.Cheesy;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

public class CheeseNukeProjectile extends ThrowableItemProjectile {
    private static final float EXPLOSION_STRENGTH = 125f;
    public CheeseNukeProjectile(EntityType<? extends CheeseNukeProjectile> p_36721_, Level p_36722_) {
        super(p_36721_, p_36722_);
    }
    public CheeseNukeProjectile(Level p_36722_) {
        super(Cheesy.CHEESE_NUKE_PROJECTILE.get(), p_36722_);
    }

    public CheeseNukeProjectile(LivingEntity p_36718_, Level p_36719_) {
        super(Cheesy.CHEESE_NUKE_PROJECTILE.get(), p_36718_, p_36719_);
    }

    @Override
    public void onAddedToWorld() {

        if (!this.level().isClientSide) {
            this.level().playSound(null,this,Cheesy.NUCLEAR_SIREN.get(), SoundSource.PLAYERS,1f,1f);
        }

        super.onAddedToWorld();
    }

    @Override
    protected void onHit(HitResult result) {
        if (!this.level().isClientSide) {
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);

            // X direction
            this.level().explode(this, result.getLocation().x - 10, result.getLocation().y, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x - 20, result.getLocation().y, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x - 30, result.getLocation().y, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x + 10, result.getLocation().y, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x + 20, result.getLocation().y, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x + 30, result.getLocation().y, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);

            // Z
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z - 10, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z - 20, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z - 30, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z + 10, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z + 20, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x, result.getLocation().y, result.getLocation().z + 30, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);

            // Y
            this.level().explode(this, result.getLocation().x, result.getLocation().y - 10, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.level().explode(this, result.getLocation().x, result.getLocation().y - 20, result.getLocation().z, EXPLOSION_STRENGTH, Level.ExplosionInteraction.BLOCK);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected @NotNull Item getDefaultItem() {
        return Cheesy.CHEESE.get();
    }
}
