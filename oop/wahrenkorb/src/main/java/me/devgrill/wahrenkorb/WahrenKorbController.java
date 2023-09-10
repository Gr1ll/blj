package me.devgrill.wahrenkorb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;

public class WahrenKorbController {

    int amount = 0;

    @FXML
    private Button hinzufügen;

    @FXML
    private TextField Produkt;

    @FXML
    private Text anzahl;

    @FXML
    private TextField quantity;

    @FXML
    private Hyperlink wahrenkorb;

    LinkedList<OrderItem> orderedItems = new LinkedList<OrderItem>();

    @FXML
    void onAdd(ActionEvent event) {
        try {
            OrderItem item = new OrderItem(Produkt.getText(), Integer.parseInt(quantity.getText()));
            orderedItems.add(item);
            amount++;
            anzahl.setText("(" + Integer.toString(amount) + ")");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void showWarenkorb(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("cart-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
            OrdersController o = new OrdersController();
            o.insertOrders(orderedItems);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
