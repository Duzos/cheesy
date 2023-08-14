package com.duzo.cheesy.creative;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.block.ModBlocks;
import com.duzo.cheesy.block.custom.CheesePortalBlock;
import com.duzo.cheesy.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cheesy.MODID);

    public static final RegistryObject<CreativeModeTab> CHEESE_TAB = TABS.register("cheese_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.cheese_tab"))
            .icon(ModItems.CHEESE.get()::getDefaultInstance)
            .displayItems((params,output) -> {
                for (RegistryObject<Item> reg : ModItems.ITEMS.getEntries()) {
                    output.accept(reg.get());
                }
                for (RegistryObject<Block> reg : ModBlocks.BLOCKS.getEntries()) {
                    if (reg.get() instanceof CheesePortalBlock) continue;

                    output.accept(reg.get());
                }
            })
            .build()
    );
}
