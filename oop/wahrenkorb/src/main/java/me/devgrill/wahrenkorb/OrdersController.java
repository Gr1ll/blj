package me.devgrill.wahrenkorb;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.LinkedList;

public class OrdersController {


    @FXML
    private TextArea orders;

    public OrdersController(){

    }

    public void insertOrders(LinkedList orderedItems){
        orders.setText(orderedItems.toString());
        //orders.setText(allItems);
    }

}
