package net.normalv.golpeclient.websocket;

import net.normalv.golpeclient.MainController;
import net.normalv.golpeclient.websocket.packets.PacketCodec;
import net.normalv.golpeclient.websocket.packets.impl.ChatPacket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

//TODO: Implement proper logging
public class WSClient extends WebSocketClient {
    public WSClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        send(PacketCodec.encode(new ChatPacket("Hello my fellas")));
        MainController.getInstance().addTextToLog("Connected successfully with status"+serverHandshake.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String message) {
        MainController.getInstance().addTextToLog("Got message: "+message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        MainController.getInstance().addTextToLog("Connection closed with code: "+code+", reason: "+reason);
    }

    @Override
    public void onError(Exception e) {
        MainController.getInstance().addTextToLog("Error: "+e.getMessage());
    }
}
