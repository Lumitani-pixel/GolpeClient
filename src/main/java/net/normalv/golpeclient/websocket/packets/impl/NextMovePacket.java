package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.manager.CardManager;
import net.normalv.golpeclient.websocket.packets.Packet;

import java.util.UUID;

public class NextMovePacket extends Packet {
    public UUID nextPlayersUuid;
    public CardManager.Card currentCard;

    public NextMovePacket(UUID nextPlayersUuid, CardManager.Card currentCard) {
        super("next_move");
        this.nextPlayersUuid = nextPlayersUuid;
        this.currentCard = currentCard;
    }
}
