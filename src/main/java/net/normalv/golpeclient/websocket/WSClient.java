package net.normalv.golpeclient.websocket;

import net.normalv.golpeclient.MainController;
import net.normalv.golpeclient.game.GameClient;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

//TODO: Implement proper logging
public class WSClient extends WebSocketClient {
    private GameClient gameClient;

    public WSClient(URI serverUri, GameClient gameClient) {
        super(serverUri);
        this.gameClient = gameClient;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log("Connected successfully with status"+serverHandshake.getHttpStatusMessage());
    }

    @Override
    public void onMessage(String message) {
        log("Got message: "+message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log("Connection closed with code: "+code+", reason: "+reason);
    }

    @Override
    public void onError(Exception e) {
        log("Error: "+e.getMessage());
    }

    public GameClient getGameClient() {
        return gameClient;
    }

    public static void log(String msg) {
        System.out.println(msg);
        MainController.getInstance().addTextToLog(msg);
    }
}
