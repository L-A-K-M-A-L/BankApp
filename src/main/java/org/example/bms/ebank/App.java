package org.example.bms.ebank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.bms.ebank.Views.ViewFactory;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
       // ob for view factory class
        ViewFactory viewFactory = new ViewFactory();
        viewFactory.showLoginWindow();
    }
}
