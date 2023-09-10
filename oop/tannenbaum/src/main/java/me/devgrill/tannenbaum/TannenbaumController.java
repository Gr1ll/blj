package me.devgrill.tannenbaum;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TannenbaumController {

    @FXML
    private Button Zeichnen;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextArea Draw;

    @FXML
    void onDraw(ActionEvent event) {
        try {
        Tanne t = new Tanne(Integer.valueOf(txt1.getText())
                , Integer.valueOf(txt2.getText())
                , Integer.valueOf(txt3.getText()));

        t.draw();

        Draw.setText(t.getTree());

        } catch (Exception e) {
            System.out.println("Bitte versuchen sie es erneut");
        }
    }
}