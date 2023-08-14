package com.duzo.cheesy.util;

import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.block.ModBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPois {
    public static final DeferredRegister<PoiType> POI = DeferredRegister.create(ForgeRegistries.POI_TYPES, Cheesy.MODID);

    public static final RegistryObject<PoiType> CHEESE_PORTAL = POI.register("cheese_portal", () -> new PoiType(ImmutableSet.copyOf(ModBlocks.PORTAL_BLOCK.get().getStateDefinition().getPossibleStates()), 0, 1));
}
