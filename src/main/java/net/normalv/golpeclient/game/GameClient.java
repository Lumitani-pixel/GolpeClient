package net.normalv.golpeclient.game;

import net.normalv.golpeclient.MainApplication;
import net.normalv.golpeclient.manager.CardManager;
import net.normalv.golpeclient.websocket.packets.PacketCodec;
import net.normalv.golpeclient.websocket.packets.impl.CardPacket;
import org.java_websocket.client.WebSocketClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameClient {
    private List<CardManager.Card> dealtCards = new ArrayList<>();
    private Player localPlayer;

    //TODO: Implement Card dealing logic and smart decision making
    public void dealCard(WebSocketClient webSocketClient) {
        Iterator<CardManager.Card> cardIterator = localPlayer.getHandCards().iterator();
        while (cardIterator.hasNext()) {
            CardManager.Card card = cardIterator.next();

            if(MainApplication.cardManager.canLayCard(dealtCards.getFirst(), card)) {
                webSocketClient.send(PacketCodec.encode(new CardPacket(card)));
                cardIterator.remove();
            }
        }
    }

    public void receiveCard(CardManager.Card card) {
        dealtCards.add(card);
    }

    public void setLocalPlayer(Player player) {
        this.localPlayer = player;
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }
}
