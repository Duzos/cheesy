package com.duzo.cheesy.util;

import com.duzo.cheesy.Cheesy;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> PORTAL_FRAME_BLOCKS = tag("portal_frame_block");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Cheesy.MODID,name));
        }
    }
}
