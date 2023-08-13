package com.duzo.cheesy.mixin;

import com.duzo.cheesy.item.CheeseGunItem;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerRenderer.class)
public class PlayerEntityRendererMixin {

	@Inject(at = @At("TAIL"), method = "getArmPose", cancellable = true)
	private static void holdBazooka(AbstractClientPlayer player, InteractionHand hand, CallbackInfoReturnable<HumanoidModel.ArmPose> ci) {
		ItemStack lv = player.getItemBySlot(EquipmentSlot.MAINHAND);
		if(lv.getItem() instanceof CheeseGunItem) {
			ci.setReturnValue(HumanoidModel.ArmPose.CROSSBOW_HOLD);
			ci.cancel();
		}
	}
}
