package net.adwaith.tutorialmod.block;

import net.adwaith.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block VIOLET_DIAMOND_BLOCK = registerBlock("violet_diamond_block", new Block(AbstractBlock.Settings.create().strength(5f,7f)
            .requiresTool().luminance((state) -> {
                return 12;
            }).sounds(BlockSoundGroup.METAL)));
    public static final Block VIOLET_DIAMOND_ORE = registerBlock("violet_diamond_ore", new Block(AbstractBlock.Settings.create().strength(5f,7f)
            .requiresTool().luminance((state) -> {
                return 5;
            }).sounds(BlockSoundGroup.METAL)));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("registering mod blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.VIOLET_DIAMOND_BLOCK);
            entries.add(ModBlocks.VIOLET_DIAMOND_ORE);
        });
    }
}
