package org.openjfx.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.openjfx.controller.PrimaryController;

import java.io.IOException;
import java.net.URL;

public class ViewFactory {
  public void showMainWindow(URL fxmlName) throws IOException {
    PrimaryController primaryController = new PrimaryController();
    sceneLoader(primaryController, fxmlName);
  }

  private void sceneLoader(PrimaryController baseController, URL fxmlName) {
    FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(fxmlName);
    fxmlLoader.setController(baseController);
    Parent parent;
    try {
      parent = fxmlLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    Scene scene = new Scene(parent, 1366, 850);
    Stage stage = new Stage();
    stage.setScene(scene);
    scene.getStylesheets().add("/org/openjfx/style.css");
    stage.show();
  }
}
