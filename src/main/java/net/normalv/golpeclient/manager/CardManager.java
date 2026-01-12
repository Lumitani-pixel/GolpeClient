package net.normalv.golpeclient.manager;

public class CardManager {
    public record Card(String color, String[] nextColors, String value) {
    }
}