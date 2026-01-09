package net.normalv.golpeclient;

import com.sun.tools.javac.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import net.normalv.golpeclient.websocket.WSClient;

import java.net.URI;
import java.net.URISyntaxException;

public class MainController {
    private static MainController instance;

    @FXML
    private Button connectButton;

    @FXML
    private TextField hostField;
    @FXML
    private TextField portField;

    @FXML
    private TextArea logs;

    public MainController() {
        instance = this;
    }

    @FXML
    protected void onConnectButtonClick() throws URISyntaxException {
        MainApplication main = MainApplication.getInstance();
        if(main.getWsClient() == null) {
            main.setWsClient(new WSClient(new URI("ws://"+getHostName()+":"+getHostPort())));
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

    private String getHostName() {
        return hostField.getText().isEmpty() ? "localhost" : hostField.getText();
    }

    private String getHostPort() {
        return portField.getText().isEmpty() ? "1598" : portField.getText();
    }

    public void addTextToLog(String text) {
        logs.appendText(text+"\n");
    }

    public static MainController getInstance() {
        return instance;
    }
}
