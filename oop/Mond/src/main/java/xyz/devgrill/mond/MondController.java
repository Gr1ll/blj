package xyz.devgrill.mond;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MondController {

    String active = "Day";

    @FXML
    private TextField Ausgabe;

    @FXML
    private RadioButton days;

    @FXML
    private RadioButton hours;

    @FXML
    private TextField txt1;

    @FXML
    void DayKlick(ActionEvent event) {
        hours.setSelected(false);
        days.setSelected(true);
        String active = "Day";
    }

    @FXML
    void HoursKlick(ActionEvent event) {
        days.setSelected(false);
        hours.setSelected(true);
        String active = "Hour";
    }

    @FXML
    void onBerechnen(ActionEvent event) {
        try {
            int kmh = Integer.parseInt(txt1.getText());
            Ausgabe.setText(Berechnen.Berechne(kmh, active));
        }catch (Exception e){
            System.out.println("Error");
        }

    }

}
