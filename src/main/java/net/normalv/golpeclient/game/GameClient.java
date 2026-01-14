package net.normalv.golpeclient.game;

public class GameClient {
    private Player localPlayer;

    public void setLocalPlayer(Player player) {
        this.localPlayer = player;
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }
}
