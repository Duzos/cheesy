package com.duzo.cheesy.sounds;

import com.duzo.cheesy.Cheesy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Cheesy.MODID);
    public static final RegistryObject<SoundEvent> NUCLEAR_SIREN = SOUNDS.register("nuclear_siren", () -> SoundEvent.createFixedRangeEvent(
            new ResourceLocation(Cheesy.MODID, "nuclear_siren"),10f));
}
