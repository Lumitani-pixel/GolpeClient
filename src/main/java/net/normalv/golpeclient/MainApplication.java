package net.normalv.golpeclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.normalv.golpeclient.websocket.WSClient;

import java.io.IOException;

public class MainApplication extends Application {
    private static MainApplication instance;
    private WSClient wsClient;

    @Override
    public void start(Stage stage) throws IOException {
        instance = this;

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ClientMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Golpe Client");
        stage.setScene(scene);
        stage.show();
    }

    public void setWsClient(WSClient wsClient) {
        this.wsClient = wsClient;
    }

    public WSClient getWsClient() {
        return wsClient;
    }

    public static MainApplication getInstance() {
        return instance;
    }
}
