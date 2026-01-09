package net.normalv.golpeclient.websocket;

import net.normalv.golpeclient.websocket.packets.PacketCodec;
import net.normalv.golpeclient.websocket.packets.impl.ChatPacket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class WSClient extends WebSocketClient {
    public WSClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        send(PacketCodec.encode(new ChatPacket("Hello my fellas")));
    }

    @Override
    public void onMessage(String s) {
    }

    @Override
    public void onClose(int i, String s, boolean b) {
    }

    @Override
    public void onError(Exception e) {
    }
}
