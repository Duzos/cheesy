package com.duzo.cheesy.item;

import com.duzo.cheesy.Cheesy;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cheesy.MODID);

    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new CheeseItem(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(5f).build())));
    public static final RegistryObject<CheeseGunItem> CHEESE_GUN = ITEMS.register("cheese_gun", () -> new CheeseGunItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<CheeseNukeItem> CHEESE_NUKE_ITEM = ITEMS.register("cheese_nuke", () -> new CheeseNukeItem(new Item.Properties().stacksTo(1)));
}
