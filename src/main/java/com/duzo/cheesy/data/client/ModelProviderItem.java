package com.duzo.cheesy.data.client;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.item.CheeseGunItem;
import com.duzo.cheesy.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

public class ModelProviderItem extends ItemModelProvider {

    public ModelProviderItem(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Cheesy.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (RegistryObject<Item> entry : ModItems.ITEMS.getEntries()) {
            if (entry.get() instanceof BlockItem item) {
                blockItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(entry.get())));
                continue;
            }
            if (entry.get() instanceof CheeseGunItem) continue;

            basicItem(entry.getId());
        }
    }


    public ItemModelBuilder blockItem(ResourceLocation item) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile(new ResourceLocation(item.getNamespace(), "block/" + item.getPath())));
    }
}
