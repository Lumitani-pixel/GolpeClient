package net.normalv.golpeclient;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import net.normalv.golpeclient.websocket.WSClient;

import java.net.URI;
import java.net.URISyntaxException;

public class MainController {
    @FXML
    private Button connectButton;

    @FXML
    private TextField hostField;
    @FXML
    private TextField portField;

    @FXML
    protected void onConnectButtonClick() throws URISyntaxException {
        MainApplication main = MainApplication.getInstance();
        if(main.getWsClient() == null) {
            main.setWsClient(new WSClient(new URI("ws://"+hostField.getText()+":"+portField.getText())));
            main.getWsClient().connect();
            connectButton.setText("Disconnect");
        }
        else if(main.getWsClient().isClosed()) {
            main.getWsClient().connect();
            connectButton.setText("Disconnect");
        }
        else {
            main.getWsClient().close();
            connectButton.setText("Connect");
        }
    }
}
