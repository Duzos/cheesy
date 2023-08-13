package com.duzo.cheesy.common;

import com.duzo.cheesy.Cheesy;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

public class CheeseTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cheesy.MODID);

    public static final RegistryObject<CreativeModeTab> CHEESE_TAB = TABS.register("cheese_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.cheese_tab"))
            .icon(Cheesy.CHEESE.get()::getDefaultInstance)
            .displayItems((params,output) -> {
                for (RegistryObject<Item> reg : Cheesy.ITEMS.getEntries()) {
                    output.accept(reg.get());
                }
            })
            .build()
    );
}
