package org.example.bms.ebank.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import org.example.bms.ebank.Controllers.Admin.ClientCellController;
import org.example.bms.ebank.Models.Client;

public class ClientCellFactory extends ListCell<Client> {
    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Admin/clientCell.fxml"));
            ClientCellController controller = new ClientCellController(client);
            loader.setController(controller);
            try {
                setGraphic(loader.load());
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
