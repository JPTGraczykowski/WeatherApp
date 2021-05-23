module pl.jgraczykowski {
    requires javafx.controls;
    requires javafx.fxml;
//    requires javafx.graphics;
    requires java.net.http;
    requires org.json;

    opens pl.jgraczykowski.controller;
    opens pl.jgraczykowski.model;
    opens pl.jgraczykowski.view;
    opens pl.jgraczykowski;
}