package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.websocket.packets.Packet;

public class StopGamePacket extends Packet {
    public String reason;

    public StopGamePacket(String reason) {
        super("stop_game");
        this.reason = reason;
    }
}
