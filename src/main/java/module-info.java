module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.controller;
    opens org.openjfx;
}