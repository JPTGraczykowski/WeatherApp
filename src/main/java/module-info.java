module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.openjfx.controller;
    opens org.openjfx.model;
    opens org.openjfx.view;
    opens org.openjfx;
}