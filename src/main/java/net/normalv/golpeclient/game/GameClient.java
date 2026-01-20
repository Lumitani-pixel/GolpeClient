package net.normalv.golpeclient.game;

import net.normalv.golpeclient.manager.CardManager;

import java.util.ArrayList;
import java.util.List;

public class GameClient {
    private List<CardManager.Card> dealtCards = new ArrayList<>();
    private Player localPlayer;

    //TODO: Implement Card dealing logic and smart decision making
    public void dealCard() {
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
