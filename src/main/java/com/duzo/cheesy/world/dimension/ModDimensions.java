package com.duzo.cheesy.world.dimension;

import com.duzo.cheesy.Cheesy;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

public class ModDimensions {
    public static final ResourceKey<Level> CHEESEDIM_KEY = createKey("cheesy");
    public static final ResourceKey<DimensionType> CHEESEDIM_TYPE = createType(CHEESEDIM_KEY);

    public static ResourceKey<Level> createKey(String id) {
        return ResourceKey.create(Registries.DIMENSION,new ResourceLocation(Cheesy.MODID,id));
    }
    public static ResourceKey<DimensionType> createType(ResourceKey<Level> key) {
        return ResourceKey.create(Registries.DIMENSION_TYPE,key.location());
    }
}
