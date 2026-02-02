package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.websocket.packets.Packet;

public class RequestCardPacket extends Packet {
    public RequestCardPacket() {
        super("request_card");
    }
}
