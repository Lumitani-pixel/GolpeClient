package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.websocket.packets.Packet;

public class ResetDeckPacket extends Packet {
    public ResetDeckPacket() {
        super("reset_deck");
    }
}
