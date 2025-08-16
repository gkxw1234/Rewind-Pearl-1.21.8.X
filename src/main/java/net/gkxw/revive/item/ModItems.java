package net.gkxw.revive.item;

import net.gkxw.revive.item.custom.ReviveItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.gkxw.revive.ReviveMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReviveMod.MOD_ID);

    public static final DeferredItem<Item> REVIVE_ITEM = ITEMS.registerItem("revive_item",
            ReviveItem::new);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
