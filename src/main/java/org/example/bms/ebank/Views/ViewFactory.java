package org.example.bms.ebank.Views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bms.ebank.Controllers.Admin.AdminController;
import org.example.bms.ebank.Controllers.Client.ClientController;

import java.io.IOException;
import java.security.PublicKey;

public class ViewFactory {
    private AccountType loginAccountType;
//    Client view
    private final ObjectProperty<ClientMenuOption> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionView;
    private AnchorPane accountsView;

//    Admin views
    private final ObjectProperty<AdminMenuOption> adminSelectedMenuItem;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositView;

//    constructor
    public ViewFactory(){
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType(){
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    //    Client view
    public ObjectProperty<ClientMenuOption> getClientSelectedMenuItem() {
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

    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }
// Admin view Section

    public ObjectProperty<AdminMenuOption> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }

    public AnchorPane getDepositView() {
        if (depositView == null ){
            try {
                depositView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Deposit.fxml")).load();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return depositView;
    }

    public AnchorPane getClientsView(){
        if(clientsView == null ){
            try{
                clientsView = new FXMLLoader(getClass().getResource("/Fxml/Admin/Clients.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return clientsView;
    }

    public AnchorPane getCreateClientView(){
        if(createClientView == null){
            try{
                createClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient.fxml")).load();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return createClientView;
    }


    public  void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        AdminController adminController = new AdminController();
        loader.setController(adminController);
        createStage(loader);
    }

    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
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
