package com.duzo.cheesy.data;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.data.client.LangEnglish;
import com.duzo.cheesy.data.client.ModelProviderItem;
import com.duzo.cheesy.data.loot.ModLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Cheesy.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerationEvent {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true,ModLootTableProvider.create(output));
        generator.addProvider(true,new LangEnglish(output));
        generator.addProvider(true,new ModelProviderItem(output,existingFileHelper));
        generator.addProvider(true,new BlockStateGenerator(output,existingFileHelper));
        generator.addProvider(true,new ModBlockTagsProvider(output,lookupProvider,existingFileHelper));
        generator.addProvider(true,new ModRecipeProvider(output));
        generator.addProvider(true,new SoundDataGeneration(output,existingFileHelper));
    }
}