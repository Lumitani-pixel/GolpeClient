package net.normalv.golpeclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.normalv.golpeclient.manager.CardManager;
import net.normalv.golpeclient.manager.PacketManager;
import net.normalv.golpeclient.websocket.WSClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application {
    private static MainApplication instance;
    private List<WSClient> wsClients = new ArrayList<>();

    public static PacketManager packetManager;
    public static CardManager cardManager;

    @Override
    public void start(Stage stage) throws IOException {
        instance = this;
        packetManager = new PacketManager();
        cardManager = new CardManager();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ClientMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Golpe Client");
        stage.setScene(scene);
        stage.show();
    }

    public void addWsClient(WSClient wsClient) {
        wsClients.add(wsClient);
    }

    public WSClient getWsClient(int index) {
        return wsClients.get(index);
    }

    public List<WSClient> getWsClients() {
        return wsClients;
    }

    public static MainApplication getInstance() {
        return instance;
    }
}
