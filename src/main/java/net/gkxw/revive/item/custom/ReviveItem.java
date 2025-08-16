package net.gkxw.revive.item.custom;

import com.ibm.icu.impl.RuleCharacterIterator;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import org.jetbrains.annotations.NotNull;

public class ReviveItem extends Item {
    public ReviveItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(Level level, @NotNull Player player, @NotNull InteractionHand hand) {
        if (!level.isClientSide) {
            level.players().forEach(plr -> {
                if (plr instanceof ServerPlayer serverPlayer) {
                    if (plr.isSpectator()) {
                        serverPlayer.setGameMode(GameType.SURVIVAL);
                        serverPlayer.teleportTo(serverPlayer.findRespawnPositionAndUseSpawnBlock(true, (player1) -> {}).position().x,
                                serverPlayer.findRespawnPositionAndUseSpawnBlock(true, (player1) -> {}).position().y,
                                serverPlayer.findRespawnPositionAndUseSpawnBlock(true, (player1) -> {}).position().z);
                        player.getItemInHand(hand).shrink(1);
                        player.displayClientMessage(Component.literal("Revived all spectator players"), true);
                    } else {
                        player.displayClientMessage(Component.literal("No spectator players to revive"), true);
                    }
                }
            });
        }
        return InteractionResult.PASS;
    }
}


