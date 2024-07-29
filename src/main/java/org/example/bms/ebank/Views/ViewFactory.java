package org.example.bms.ebank.Views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bms.ebank.Controllers.Client.ClientController;

import java.io.IOException;

public class ViewFactory {

//    Client view
    private final StringProperty clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionView;
    private AnchorPane accountsView;
//    constructor
    public ViewFactory(){
        this.clientSelectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionView(){
        if(transactionView == null){
            try {
                transactionView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transaction.fxml")).load();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return transactionView;
    }

    public AnchorPane getAccountsView(){
        if(accountsView == null ){
            try{
                accountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Account.fxml")).load();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return  accountsView;
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(loader);
    }

    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("E BANK");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }

}
