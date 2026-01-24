package net.normalv.golpeclient.manager;

import java.util.Arrays;

public class CardManager {
    public boolean canLayCard(Card topCard, Card dealtCard) {
        if(dealtCard.color.equalsIgnoreCase("black") ||
                Arrays.asList(topCard.nextColors).contains(dealtCard.color) ||
                topCard.value.equals(dealtCard.value))
            return true;

        return false;
    }

    public record Card(String color, String[] nextColors, String value) {
    }
}