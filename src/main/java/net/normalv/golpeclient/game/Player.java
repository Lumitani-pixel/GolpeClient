package net.normalv.golpeclient.game;

import net.normalv.golpeclient.manager.CardManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private List<CardManager.Card> handCards = new ArrayList<>();
    private UUID uuid;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public boolean hasCard(CardManager.Card card) {
        return handCards.contains(card);
    }

    public void addCard(CardManager.Card card) {
        handCards.add(card);
    }

    public void addCards(List<CardManager.Card> cards) {
        handCards.addAll(cards);
    }

    public List<CardManager.Card> getHandCards() {
        return handCards;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
