package com.duzo.cheesy.data;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.sounds.ModSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;
import net.minecraftforge.registries.RegistryObject;

public class SoundDataGeneration extends SoundDefinitionsProvider {

    public SoundDataGeneration(PackOutput output, ExistingFileHelper helper) {
        super(output, Cheesy.MODID, helper);
    }

    @Override
    public void registerSounds() {
        for (RegistryObject<SoundEvent> entry : ModSounds.SOUNDS.getEntries()) {
            createDefinitionAndAdd(entry.get(), SoundDefinition.SoundType.SOUND, entry.get().getLocation().getPath(), entry.get().getLocation().getPath());
        }
    }

    public void createDefinitionAndAdd(SoundEvent mainSound, SoundDefinition.SoundType soundType, String subtitle, String... soundEvent) {
        SoundDefinition def = SoundDefinition.definition().subtitle("subtitle." + Cheesy.MODID + "." + subtitle);
        for (String event : soundEvent) {
            def.with(SoundDefinition.Sound.sound(new ResourceLocation(Cheesy.MODID, event), soundType));
        }
        add(mainSound, def);
    }
}
