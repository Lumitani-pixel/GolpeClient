package net.normalv.golpeclient.manager;

import net.normalv.golpeclient.websocket.packets.Packet;
import net.normalv.golpeclient.websocket.packets.impl.CardPacket;
import net.normalv.golpeclient.websocket.packets.impl.ChatPacket;
import net.normalv.golpeclient.websocket.packets.impl.RegisterPacket;

import java.util.HashMap;
import java.util.Map;

public class PacketManager {
    private final Map<String, Class<? extends Packet>> PACKETS = new HashMap<>();

    public PacketManager() {
        register("chat", ChatPacket.class);
        register("card", CardPacket.class);
        register("register", RegisterPacket.class);
    }

    public void register(String id, Class<? extends Packet> clazz) {
        PACKETS.put(id, clazz);
    }

    public Class<? extends Packet> get(String id) {
        return PACKETS.get(id);
    }
}
