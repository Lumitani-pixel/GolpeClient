package net.normalv.golpeclient.manager;

import java.util.Arrays;

public class CardManager {
    // Check if dealtCard can be played on topCard (same logic as server)
    public boolean canLayCard(Card topCard, Card dealtCard) {
        // Black cards (wild) can always be played
        if (dealtCard.color.equalsIgnoreCase("black")) {
            return true;
        }

        // Match by color
        if (Arrays.asList(topCard.nextColors).contains(dealtCard.color)) {
            return true;
        }

        // Match by value
        if (topCard.value.equals(dealtCard.value)) {
            return true;
        }

        return false;
    }

    public record Card(String color, String[] nextColors, String value) {
    }
}