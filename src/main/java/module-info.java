module org.example.bms.ebank {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens org.example.bms.ebank to javafx.fxml;
    exports org.example.bms.ebank;
    exports org.example.bms.ebank.Controllers;
    exports org.example.bms.ebank.Controllers.Admin;
    exports org.example.bms.ebank.Controllers.Client;
    exports org.example.bms.ebank.Models;
    exports org.example.bms.ebank.Views;
}