package com.duzo.cheesy;

import com.duzo.cheesy.block.ModBlocks;
import com.duzo.cheesy.creative.ModTabs;
import com.duzo.cheesy.entity.ModEntities;
import com.duzo.cheesy.item.ModItems;
import com.duzo.cheesy.models.CheeseNukeModel;
import com.duzo.cheesy.renderers.CheeseNukeRenderer;
import com.duzo.cheesy.sounds.ModSounds;
import com.duzo.cheesy.util.ModPois;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
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
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Cheesy.MODID)
public class Cheesy {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "cheesy";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Cheesy() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModItems.ITEMS.register(modEventBus);
        ModEntities.ENTITY_TYPES.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);
        ModTabs.TABS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModPois.POI.register(modEventBus);

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
            renderers.registerEntityRenderer(ModEntities.CHEESE_PROJECTILE.get(), ThrownItemRenderer::new);
            renderers.registerEntityRenderer(ModEntities.CHEESE_NUKE_PROJECTILE.get(), CheeseNukeRenderer::new);
        }
        @SubscribeEvent
        public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(CheeseNukeModel.LAYER_LOCATION,CheeseNukeModel::createBodyLayer);
        }
    }
}
