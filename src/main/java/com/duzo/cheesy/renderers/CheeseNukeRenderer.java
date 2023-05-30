package com.duzo.cheesy.renderers;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.common.CheeseNukeProjectile;
import com.duzo.cheesy.models.CheeseNukeModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.AbstractArrow;
import org.jetbrains.annotations.NotNull;

public class CheeseNukeRenderer<T extends CheeseNukeProjectile> extends EntityRenderer<T> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Cheesy.MODID, "textures/entity/cheese_nuke.png");
    private CheeseNukeModel<T> model;

    public CheeseNukeRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new CheeseNukeModel<>(context.bakeLayer(CheeseNukeModel.LAYER_LOCATION));
    }

    @Override
    public void render(@NotNull T entity, float partialTick, float p_114487_, @NotNull PoseStack stack, MultiBufferSource source, int packedLight) {
        this.model.renderToBuffer(stack,source.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(entity))),packedLight, OverlayTexture.NO_OVERLAY,1,1,1,1);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull T entity) {
        return TEXTURE;
    }
}
