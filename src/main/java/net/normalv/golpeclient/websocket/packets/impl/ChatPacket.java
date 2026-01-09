package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.websocket.packets.Packet;

public class ChatPacket extends Packet {
    public String message;

    public ChatPacket(String message) {
        super("chat");
        this.message = message;
    }
}
