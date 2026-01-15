module net.normalv.golpeclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.java_websocket;
    requires com.google.gson;
    requires jdk.compiler;

    opens net.normalv.golpeclient.websocket.packets.impl to com.google.gson;
    opens net.normalv.golpeclient.websocket.packets to com.google.gson;
    opens net.normalv.golpeclient.manager to com.google.gson;

    opens net.normalv.golpeclient to javafx.fxml;
    exports net.normalv.golpeclient;
}