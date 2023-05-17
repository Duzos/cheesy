package com.duzo.cheesy.rendering;

import com.duzo.cheesy.common.CheeseProjectile;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CheesyProjectileRenderer extends ArrowRenderer<CheeseProjectile> {
    public CheesyProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(CheeseProjectile projectile) {
        return new ResourceLocation("textures/entity/projectiles/arrow.png");
    }
}
