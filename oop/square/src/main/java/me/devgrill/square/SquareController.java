package me.devgrill.square;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SquareController {

    @FXML
    private Button Beenden;

    @FXML
    private Button Berechnen;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    void onBeenden(ActionEvent event) {
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
    }

    @FXML
    void onBerechnen(ActionEvent event) {
        String breite = txt1.getText();
        String hoehe = txt2.getText();
        if(!breite.equals("") || !hoehe.equals("")){
            try
            {
                double flaeche = Double.parseDouble(breite) * Double.parseDouble(hoehe);
                txt3.setText(Double.toString(flaeche));
            }
            catch(NumberFormatException e)
            {
                txt3.setText("Error");
            }
        }else{
            txt3.setText("Error");
        }
    }

}
