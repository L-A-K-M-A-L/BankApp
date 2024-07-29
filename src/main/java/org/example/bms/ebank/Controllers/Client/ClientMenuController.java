package org.example.bms.ebank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.example.bms.ebank.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
    public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {
        dashboard_btn.setOnAction(event -> onDashboard());
        transaction_btn.setOnAction(event -> onTransaction());
        accounts_btn.setOnAction(event -> onAccount());
    }

    private void onDashboard(){
//        System.out.println("Dashboard button clicked");
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Dashboard");
    }

    private void onTransaction() {
//        System.out.println("Transaction button clicked");
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Transaction");
    }

    private void onAccount(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Account");
    }
}
