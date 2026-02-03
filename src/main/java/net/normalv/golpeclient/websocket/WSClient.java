package net.normalv.golpeclient.websocket;

import net.normalv.golpeclient.MainController;
import net.normalv.golpeclient.game.GameClient;
import net.normalv.golpeclient.game.Player;
import net.normalv.golpeclient.websocket.packets.Packet;
import net.normalv.golpeclient.websocket.packets.PacketCodec;
import net.normalv.golpeclient.websocket.packets.impl.*;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Arrays;
import java.util.Random;

//TODO: Implement proper logging
public class WSClient extends WebSocketClient {
    private GameClient gameClient;

    public WSClient(URI serverUri, GameClient gameClient) {
        super(serverUri);
        this.gameClient = gameClient;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        log("Connected successfully with status: "+serverHandshake.getHttpStatusMessage());

        Player player = new Player(MainController.getInstance().useRandomName() ? "Bot"+ new Random().nextInt(1000) : MainController.getInstance().getBotName());
        gameClient.setLocalPlayer(player);
        send(PacketCodec.encode(new RegisterPacket(player.getName())));
        log("Registering under name: "+player.getName());
    }

    @Override
    public void onMessage(String message) {
        log("Got message: "+message);

        Packet packet = PacketCodec.decode(message);

        if(packet instanceof ConfirmRegistrationPacket confirmRegistrationPacket){
            gameClient.getLocalPlayer().setUuid(confirmRegistrationPacket.uuid);
            log("Got in assigned uuid: "+confirmRegistrationPacket.uuid);
        }
        else if(packet instanceof CardPacket cardPacket) {
            gameClient.getLocalPlayer().addCard(cardPacket.card);
        }
        else if(packet instanceof NextMovePacket nextMovePacket) {
            gameClient.receiveCard(nextMovePacket.currentCard);
            if(!nextMovePacket.nextPlayersUuid.equals(gameClient.getLocalPlayer().getUuid())) return;
            gameClient.dealCard(this);
        }
        else if(packet instanceof ResetDeckPacket) {
            gameClient.resetDeck();
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log("Connection closed with code: "+code+", reason: "+reason);
    }

    @Override
    public void onError(Exception e) {
        log("Error: "+e.getMessage()+" and stacktrace: "+ Arrays.toString(e.getStackTrace()));
    }

    public GameClient getGameClient() {
        return gameClient;
    }

    public static void log(String msg) {
        System.out.println(msg);
        MainController.getInstance().addTextToLog(msg);
    }
}
