package org.example.bms.ebank.Models;

import org.example.bms.ebank.Views.AccountType;
import org.example.bms.ebank.Views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Model {
    private static Model model;
    private final ViewFactory viewFactory;
    private final DataBaseDriver dataBaseDriver;
    private AccountType logingAccountType = AccountType.CLIENT;

//    Client data section
    private final Client client;
    private boolean clientLoginSuccessFlag;
//    Admin data section

    public Model() {
        this.viewFactory = new ViewFactory();
        this.dataBaseDriver = new DataBaseDriver();
//        Client data section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("", "","",null,null, null);
//        Admin data section
    }

    public static synchronized Model getInstance(){
        if(model == null) {
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory(){
        return viewFactory;
    }

    public DataBaseDriver getDataBaseDriver() {
        return dataBaseDriver;
    }

    public AccountType getLogingAccountType() {
        return logingAccountType;
    }

    public void setLogingAccountType(AccountType logingAccountType) {
        this.logingAccountType = logingAccountType;
    }

    //    Client Method Section
    public boolean getClientLoginSuccessFlag(){
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag){
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient() {
        return client;
    }

    public void evaluateClientCred(String pAddrerss, String password){
        CheckingAccount checkingAccount;
        SavingAccount savingAccount;

        ResultSet resultSet = dataBaseDriver.getClientData(pAddrerss, password);

        try {
            if (resultSet.isBeforeFirst()){
               this.client.firstNameProperty().set(resultSet.getString("FirstName"));
               this.client.lastNameProperty().set(resultSet.getString("LastName"));
               this.client.pAddressProperty().set(resultSet.getString("PayeeAddress"));
               String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                this.client.dateCreatedProperty().set(date);
                this.clientLoginSuccessFlag = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}






















