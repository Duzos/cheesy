package com.duzo.cheesy.data.client;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.entity.ModEntities;
import com.duzo.cheesy.item.ModItems;
import com.duzo.cheesy.sounds.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class LangEnglish extends LanguageProvider {

    public LangEnglish(PackOutput gen) {
        super(gen, Cheesy.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Automated translation based off registry name
        for (RegistryObject<Item> obj : ModItems.ITEMS.getEntries()) {
            Item item = obj.get();

            add(item,toName(item));
        }
        for (RegistryObject<EntityType<?>> obj : ModEntities.ENTITY_TYPES.getEntries()) {
            add(obj.get(),toName(obj.get()));
        }
        for (RegistryObject<SoundEvent> obj : ModSounds.SOUNDS.getEntries()) {
            add(getSubtitle(obj.get()),toName(obj.get()));
        }
//        for (RegistryObject<Block> obj : ModBlocks.BLOCKS.getEntries()) {
//            add(obj.get(),toName(obj.get()));
//        }

        add("itemGroup.cheese_tab","Cheesy");
    }

    public static String getSubtitle(SoundEvent sound) {
        return "subtitle." + Cheesy.MODID + "." + sound.getLocation().getPath();
    }

    public static String toName(Item item) {
        String id = item.getDescriptionId(); // blah.cheesy.blah_blah_blah
        String sub = id.substring(id.lastIndexOf(".") + 1); // blah_blah_blah

        String spaced = sub.replace("_", " ");
        String[] words = spaced.split(" ");
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return output.toString().substring(0,output.toString().length() - 1);
    }
    public static String toName(EntityType<?> entity) {
        String id = entity.getDescriptionId(); // blah.cheesy.blah_blah_blah
        String sub = id.substring(id.lastIndexOf(".") + 1); // blah_blah_blah

        String spaced = sub.replace("_", " ");
        String[] words = spaced.split(" ");
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return output.toString().substring(0,output.toString().length() - 1);
    }
    public static String toName(Block block) {
        String id = block.getDescriptionId(); // blah.cheesy.blah_blah_blah
        String sub = id.substring(id.lastIndexOf(".") + 1); // blah_blah_blah

        String spaced = sub.replace("_", " ");
        String[] words = spaced.split(" ");
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return output.toString().substring(0,output.toString().length() - 1);
    }
    public static String toName(SoundEvent sound) {
        String sub = sound.getLocation().getPath(); // the sound part in cheesy:sound

        String spaced = sub.replace("_", " ");
        String[] words = spaced.split(" ");
        StringBuilder output = new StringBuilder();
        for (String word : words) {
            output.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return output.toString().substring(0,output.toString().length() - 1);
    }
}
