package xyz.devgrill.mond;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MondApplication extends Application {
    @Override    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MondApplication.class.getResource("mond-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Mond!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}