package org.example.bms.ebank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import org.example.bms.ebank.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    public BorderPane client_parent;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observable, oldVal, newVal) -> {
//            System.out.println("Selected menu item: " + newVal);
            switch (newVal) {
                case TRANSACTIONS -> {
//                    System.out.println("Switching to Transaction view");
                    client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionView());
                }
                case ACCOUNTS -> {
                    client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                }
                default -> {
//                    System.out.println("Switching to Dashboard view");
                    client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                }
            }
        });
    }
}
