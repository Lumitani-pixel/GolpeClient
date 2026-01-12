package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.manager.CardManager;
import net.normalv.golpeclient.websocket.packets.Packet;

public class CardPacket extends Packet {
    public CardManager.Card card;

    public CardPacket(CardManager.Card card) {
        super("card");
        this.card = card;
    }
}
