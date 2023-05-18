package com.duzo.cheesy.common;

import com.duzo.cheesy.Cheesy;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class CheeseGunItem extends CrossbowItem {
    public CheeseGunItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            if (player.getAbilities().instabuild) {
                shootCheese(player,level);
                return InteractionResultHolder.consume(player.getItemInHand(hand));
            }

            ItemStack cheesyStack = getCheeseInInventory(player);
            if (cheesyStack != null) {
                cheesyStack.shrink(1);
                shootCheese(player, level);
                return InteractionResultHolder.consume(player.getItemInHand(hand));
            }
        }
        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }

    private ItemStack getCheeseInInventory(Player player) {
        for(int i = 0; i < player.getInventory().getContainerSize(); ++i) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.is(Cheesy.CHEESE.get())) {
                return stack;
            }
        }
        return null;
    }

    private void shootCheese(Player player, Level level) {
        player.getCooldowns().addCooldown(this.asItem(),60);

        CheeseProjectile projectile = new CheeseProjectile(player,level);

        Vec3 vec31 = player.getUpVector(1.0F);
        Quaternionf quaternionf = (new Quaternionf()).setAngleAxis((double)(0 * ((float)Math.PI / 180F)), vec31.x, vec31.y, vec31.z);
        Vec3 vec3 = player.getViewVector(1.0F);
        Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);
        projectile.shoot((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), 1.5f, 1F);

        level.addFreshEntity(projectile);
    }
}
