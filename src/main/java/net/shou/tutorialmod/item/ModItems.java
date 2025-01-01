package net.shou.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.shou.tutorialmod.TutorialMod;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet");
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet");
    public static final Item PEEPO_CRY = registerItem("peepo_cry");

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items...");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(PEEPO_CRY);
        });
    }

    /**
     * Helper method to register an Item to the Registry.
     * @param name In-game name of the item. Should be lower-snake case
     * @return a reference to the registered Item
     */
    private static Item registerItem(String name) {
        final Item itemToRegister = new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name))));
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), itemToRegister);
    }
}
