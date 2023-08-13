package com.duzo.cheesy;

import com.duzo.cheesy.common.*;
import com.duzo.cheesy.models.CheeseNukeModel;
import com.duzo.cheesy.renderers.CheeseNukeRenderer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Cheesy.MODID)
public class Cheesy {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "cheesy";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cheesy.MODID);
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationMod(5f).build())));
    public static final RegistryObject<CheeseGunItem> CHEESE_GUN = ITEMS.register("cheese_gun", () -> new CheeseGunItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<CheeseNukeItem> CHEESE_NUKE_ITEM = ITEMS.register("cheese_nuke", () -> new CheeseNukeItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<EntityType<CheeseProjectile>> CHEESE_PROJECTILE = ENTITY_TYPES.register("cheese_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<CheeseProjectile>) CheeseProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("cheese_projectile"));
    public static final RegistryObject<EntityType<CheeseNukeProjectile>> CHEESE_NUKE_PROJECTILE = ENTITY_TYPES.register("cheese_nuke_projectile",
            () -> EntityType.Builder.of((EntityType.EntityFactory<CheeseNukeProjectile>) CheeseNukeProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F).build("cheese_nuke_projectile"));

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MODID);
    public static final RegistryObject<SoundEvent> NUCLEAR_SIREN = SOUNDS.register("nuclear_siren", () -> SoundEvent.createFixedRangeEvent(
            new ResourceLocation(MODID, "nuclear_siren"),10f));

    public Cheesy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ITEMS.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
        SOUNDS.register(modEventBus);
        CheeseTabs.TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers renderers) {
            renderers.registerEntityRenderer(CHEESE_PROJECTILE.get(), ThrownItemRenderer::new);
            renderers.registerEntityRenderer(CHEESE_NUKE_PROJECTILE.get(), CheeseNukeRenderer::new);
        }
        @SubscribeEvent
        public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(CheeseNukeModel.LAYER_LOCATION,CheeseNukeModel::createBodyLayer);
        }
    }
}
