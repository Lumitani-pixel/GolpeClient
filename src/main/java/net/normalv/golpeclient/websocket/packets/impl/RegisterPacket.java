package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.websocket.packets.Packet;

public class RegisterPacket extends Packet {
    public String name;

    public RegisterPacket(String name) {
        super("register");
        this.name = name;
    }
}
