package net.normalv.golpeclient.websocket.packets.impl;

import net.normalv.golpeclient.websocket.packets.Packet;

import java.util.UUID;

public class ConfirmRegistrationPacket extends Packet {
    public UUID uuid;

    public ConfirmRegistrationPacket(UUID uuid) {
        super("confirm_registration");
        this.uuid = uuid;
    }
}
