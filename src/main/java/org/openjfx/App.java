package org.openjfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.openjfx.view.ViewFactory;
import static org.openjfx.config.Constants.*;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showMainWindow(getClass().getResource(FXML_NAME));
    }

    public static void main(String[] args) {
        launch();
    }

}