package pl.jgraczykowski;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.jgraczykowski.view.ViewFactory;
import pl.jgraczykowski.config.Constants;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    ViewFactory viewFactory = new ViewFactory();
    viewFactory.showMainWindow(getClass().getResource(Constants.FXML_NAME));
  }

  public static void main(String[] args) {
    launch();
  }

}