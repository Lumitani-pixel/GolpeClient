package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.websocket.packets.Packet;

public class RejectCardPacket extends Packet {
    public String reason;

    public RejectCardPacket(String reason) {
        super("reject_card");
        this.reason = reason;
    }
}
