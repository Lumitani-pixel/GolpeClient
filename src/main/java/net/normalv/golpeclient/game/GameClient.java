package net.normalv.golpeclient.game;

import net.normalv.golpeclient.MainApplication;
import net.normalv.golpeclient.manager.CardManager;
import net.normalv.golpeclient.websocket.packets.PacketCodec;
import net.normalv.golpeclient.websocket.packets.impl.CardPacket;
import net.normalv.golpeclient.websocket.packets.impl.CantDealPacket;
import org.java_websocket.client.WebSocketClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameClient {
    // Cards on the table (the pile)
    private List<CardManager.Card> dealtCards = new ArrayList<>();
    
    // The local player (this client)
    private Player localPlayer;

    //TODO: Implement Card dealing logic and smart decision making
    
    // Attempt to play a valid card, or draw from deck if none available
    public void dealCard(WebSocketClient webSocketClient) {
        Iterator<CardManager.Card> cardIterator = localPlayer.getHandCards().iterator();
        
        while (cardIterator.hasNext()) {
            CardManager.Card card = cardIterator.next();

            // Find first playable card
            if (MainApplication.cardManager.canLayCard(dealtCards.getFirst(), card)) {
                webSocketClient.send(PacketCodec.encode(new CardPacket(card)));
                cardIterator.remove();
                return;
            }
        }
        
        // No playable cards - request one from deck
        webSocketClient.send(PacketCodec.encode(new CantDealPacket()));
    }

    // Called when server tells us what card is on top
    public void receiveCard(CardManager.Card card) {
        dealtCards.add(card);
    }

    // Reset pile when deck is reshuffled
    public void resetDeck() {
        while (dealtCards.size() > 1) {
            dealtCards.removeLast();
        }
    }

    public void setLocalPlayer(Player player) {
        this.localPlayer = player;
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }
}
