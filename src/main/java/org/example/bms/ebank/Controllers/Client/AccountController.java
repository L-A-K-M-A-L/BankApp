package org.example.bms.ebank.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable {
    public Label checking_acc_num;
    public Label transaction_limit;
    public Label ch_acc_date;
    public Label ch_acc_bal;
    public Label sv_acc_num;
    public Label sv_acc_date;
    public Label sv_acc_bal;
    public TextField trans_amount_to_sv;
    public Button trans_amount_to_sv_btn;
    public TextField trans_amount_to_ch;
    public Button trans_amount_to_ch_btn;
    public Label withdrawal_limit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
