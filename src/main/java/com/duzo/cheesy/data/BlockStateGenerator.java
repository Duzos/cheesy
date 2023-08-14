package com.duzo.cheesy.data;
import com.duzo.cheesy.Cheesy;
import com.duzo.cheesy.block.ModBlocks;
import com.duzo.cheesy.block.custom.CheesePortalBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlockStateGenerator extends BlockStateProvider {
    private final ExistingFileHelper fileHelper;
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Cheesy.MODID, exFileHelper);
        this.fileHelper = exFileHelper;
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> entry : ModBlocks.BLOCKS.getEntries()) {
            if (entry.get() instanceof CheesePortalBlock) continue;

            // @TODO this better
            if (entry.get() instanceof StairBlock) {
                stairsBlock((StairBlock) entry.get(), new ResourceLocation(Cheesy.MODID,"textures/block/" + entry.get().getDescriptionId() + ".png"));
                continue;
            }
            if (entry.get() instanceof WallBlock) {
                wallBlock((WallBlock) entry.get(), new ResourceLocation(Cheesy.MODID,"textures/block/" + entry.get().getDescriptionId() + ".png"));
            }
            if (entry.get() instanceof SlabBlock) {
                slabBlock((SlabBlock) entry.get(), new ResourceLocation(Cheesy.MODID,"textures/block/" + entry.get().getDescriptionId() + ".png"), new ResourceLocation(Cheesy.MODID,"textures/block/" + entry.get().getDescriptionId() + ".png"));
            }
            if (entry.get() instanceof IronBarsBlock) {
                paneBlock((IronBarsBlock) entry.get(),new ResourceLocation(Cheesy.MODID,"textures/block/" + entry.get().getDescriptionId() + ".png"),new ResourceLocation(Cheesy.MODID,"textures/block/" + entry.get().getDescriptionId() + "_side.png"));
            }

            simpleBlock(entry.get());
        }
    }
}
