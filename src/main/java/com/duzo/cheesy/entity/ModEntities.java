package com.duzo.cheesy.entity;

import com.duzo.cheesy.Cheesy;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Cheesy.MODID);

    public static final RegistryObject<EntityType<CheeseProjectile>> CHEESE_PROJECTILE = ENTITY_TYPES.register("cheese_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<CheeseProjectile>) CheeseProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("cheese_projectile"));
    public static final RegistryObject<EntityType<CheeseNukeProjectile>> CHEESE_NUKE_PROJECTILE = ENTITY_TYPES.register("cheese_nuke_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<CheeseNukeProjectile>) CheeseNukeProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("cheese_nuke_projectile"));
}
