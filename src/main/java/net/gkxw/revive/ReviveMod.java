package net.gkxw.revive;

import net.minecraft.network.ServerboundPacketListener;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.gkxw.revive.item.ModItems;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ReviveMod.MOD_ID)
public class ReviveMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "gkxwrevivemod";
    public static final Logger LOGGER = LogUtils.getLogger();


    public ReviveMod(IEventBus modEventBus) {
        modEventBus.addListener(this::addCreative);
        ModItems.register(modEventBus);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.REVIVE_ITEM);
        }
    }

    @SubscribeEvent
    public void event(UseItemOnBlockEvent event) {
        if (!event.getLevel().isClientSide) {
            if (event.getPlayer() instanceof ServerPlayer serverPlayer) {
                if (serverPlayer.hasItemInSlot(EquipmentSlot.MAINHAND)) {
                    if (serverPlayer.getMainHandItem().is(Items.DIAMOND)) {

                    }
                    if (serverPlayer.getMainHandItem().is(Items.IRON_AXE)) {

                    }
                    if (serverPlayer.getMainHandItem().is(Items.DIAMOND_AXE)) {

                    }
                }
            }
        }
    }
}