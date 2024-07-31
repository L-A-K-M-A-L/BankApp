package org.example.bms.ebank.Models;

import java.sql.*;

public class DataBaseDriver {
    private Connection conn;

    public DataBaseDriver(){
        try {
            this.conn = DriverManager.getConnection("jdbc:sqlite:ebank.db");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//  Client section
    public ResultSet getClientData(String pAddress, String password){
        Statement statement;
        ResultSet resultSet = null;

        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password'"+password+"';");

        }catch (SQLException e){
            e.printStackTrace();
        }

        return resultSet;
    }

}
