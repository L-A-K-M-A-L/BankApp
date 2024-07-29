package org.example.bms.ebank;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.bms.ebank.Models.Model;


public class App extends Application {

    @Override
    public void start(Stage stage) {

        Model.getInstance().getViewFactory().showLoginWindow();

    }
}
