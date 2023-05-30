package com.duzo.cheesy.common;

import com.duzo.cheesy.Cheesy;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CheeseNukeItem extends Item {
    public CheeseNukeItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        level.playSound(null,player.getX(),player.getY(),player.getZ(), Cheesy.NUCLEAR_SIREN.get(), SoundSource.PLAYERS,1f,1f);

        if (!level.isClientSide) {
            CheeseNukeProjectile nuke = new CheeseNukeProjectile(level);
            nuke.setPos(pos.getX(),1024,pos.getZ());
            level.addFreshEntity(nuke);

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
}
