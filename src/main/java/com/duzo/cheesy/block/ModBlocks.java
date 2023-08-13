package com.duzo.cheesy.block;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cheesy.MODID);

    public static final RegistryObject<Block> CHEESE_BLOCK = register("cheese_block", () ->
            new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW)
                    .strength(0.5F, 0.5F)), new Item.Properties());
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties ){
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
        return block;
    }
}
