package net.adwaith.tutorialmod.items;

import net.adwaith.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item VIOLET_DIAMOND = registerItem("violet_diamond", new Item(new Item.Settings()));

    public static Item registerItem(String name, Item item){
    return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
    TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);

    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
        entries.add(VIOLET_DIAMOND);
    });
    }
}
