package net.normalv.golpeclient;

import com.sun.tools.javac.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import net.normalv.golpeclient.game.GameClient;
import net.normalv.golpeclient.websocket.WSClient;

import java.net.URI;
import java.net.URISyntaxException;

public class MainController {
    private static MainController instance;

    @FXML
    private Button connectButton;
    @FXML
    private ToggleButton randomName;

    @FXML
    private TextField hostField;
    @FXML
    private TextField portField;
    @FXML
    private TextField botAmount;
    @FXML
    private TextField botName;

    @FXML
    private TextArea logs;

    public MainController() {
        instance = this;
    }

    @FXML
    protected void onConnectButtonClick() throws URISyntaxException {
        MainApplication main = MainApplication.getInstance();
        if(main.getWsClients().isEmpty()) {
            for(int i = 0; i<getBotCount(); i++) {
                main.addWsClient(new WSClient(new URI("ws://"+getHostName()+":"+getHostPort()), new GameClient()));
                main.getWsClient(i).connect();
            }
            connectButton.setText("Disconnect");
        }
        else if(connectButton.getText().equals("Connect")) {
            for(WSClient wsClient : main.getWsClients()) {
                if(wsClient.isOpen()) wsClient.close();
            }
            connectButton.setText("Disconnect");
        }
        else {
            for(WSClient wsClient : main.getWsClients()) {
                if(wsClient.isOpen()) wsClient.close();
            }
            connectButton.setText("Connect");
        }
    }



    private String getHostName() {
        return hostField.getText().isEmpty() ? "localhost" : hostField.getText();
    }

    private String getHostPort() {
        return portField.getText().isEmpty() ? "1598" : portField.getText();
    }

    private int getBotCount() {
        return botAmount.getText().isEmpty() ? 1 : Integer.parseInt(botAmount.getText());
    }

    public void addTextToLog(String text) {
        Platform.runLater(() -> logs.appendText(text + "\n"));
    }

    public boolean useRandomName() {
        return randomName.isSelected();
    }

    public String getBotName() {
        return botName.getText();
    }

    public static MainController getInstance() {
        return instance;
    }
}
