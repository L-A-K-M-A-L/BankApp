package org.example.bms.ebank.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bms.ebank.Controllers.Client.ClientController;

public class ViewFactory {

//    Client view
    private AnchorPane dashboardView;
    private AnchorPane transactionView;
//    constructor
    public ViewFactory(){

    }

    public AnchorPane getDashboardView(){
        if(dashboardView == null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionView(){
        if(transactionView == null){
            try {
                transactionView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transaction.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return transactionView;
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
