module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;

    opens org.openjfx.controller;
    opens org.openjfx.model;
    opens org.openjfx.view;
    opens org.openjfx;
}