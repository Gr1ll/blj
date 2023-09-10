package xyz.devgrill.snake.register;

import javafx.application.Application;
import javafx.scene.layout.ColumnConstraints;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Window;
import xyz.devgrill.snake.Main;
import xyz.devgrill.snake.leaderboard.LeaderBoard;
import xyz.devgrill.snake.sql.LoginManager;
import xyz.devgrill.snake.sql.ScoreManager;

public class Register extends Application {

    private static int modus = 1;

    public void start(Stage stage) throws Exception {
        stage.setTitle("Registration Form JavaFX Application");

        GridPane gridPane = createRegistrationFormPane();
        addUIControls(gridPane);
        Scene scene = new Scene(gridPane, 800, 500);
        stage.setScene(scene);
        stage.show();
    }


    private GridPane createRegistrationFormPane() {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);

        gridPane.setPadding(new Insets(40, 40, 40, 40));

        gridPane.setHgap(10);

        gridPane.setVgap(10);

        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        Label headerLabel = new Label("Registration/Login Form");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

        Label nameLabel = new Label("Username : ");
        gridPane.add(nameLabel, 0,1);

        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        gridPane.add(nameField, 1,1);

        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 2);

        Button mode1 = new Button("Modus 1");
        mode1.setPrefHeight(40);
        mode1.setDefaultButton(true);
        mode1.setPrefWidth(100);
        gridPane.add(mode1, 0, 4, 1, 1);
        GridPane.setHalignment(mode1, HPos.CENTER);
        GridPane.setMargin(mode1, new Insets(20, 0,20,0));

        Button mode2 = new Button("Modus 2");
        mode2.setPrefHeight(40);
        mode2.setDefaultButton(true);
        mode2.setPrefWidth(100);
        gridPane.add(mode2, 0, 4, 3, 1);
        GridPane.setHalignment(mode2, HPos.CENTER);
        GridPane.setMargin(mode2, new Insets(20, 0,20,0));

        Button mode3 = new Button("Modus 3");
        mode3.setPrefHeight(40);
        mode3.setDefaultButton(true);
        mode3.setPrefWidth(100);
        gridPane.add(mode3, 2, 4, 1, 1);
        GridPane.setHalignment(mode3, HPos.CENTER);
        GridPane.setMargin(mode3, new Insets(20, 0,20,0));

        Button leaderboardbtn_one = new Button("leaderboard1");
        leaderboardbtn_one.setPrefHeight(40);
        leaderboardbtn_one.setDefaultButton(false);
        leaderboardbtn_one.setPrefWidth(100);
        gridPane.add(leaderboardbtn_one, 0, 4, 1, 15);
        GridPane.setHalignment(leaderboardbtn_one, HPos.CENTER);
        GridPane.setMargin(leaderboardbtn_one, new Insets(20, 0,20,0));

        Button leaderboardbtn_two = new Button("leaderboard2");
        leaderboardbtn_two.setPrefHeight(40);
        leaderboardbtn_two.setDefaultButton(false);
        leaderboardbtn_two.setPrefWidth(100);
        gridPane.add(leaderboardbtn_two, 0, 4, 3, 15);
        GridPane.setHalignment(leaderboardbtn_two, HPos.CENTER);
        GridPane.setMargin(leaderboardbtn_two, new Insets(20, 0,20,0));

        Button leaderboardbtn_three = new Button("leaderboard3");
        leaderboardbtn_three.setPrefHeight(40);
        leaderboardbtn_three.setDefaultButton(false);
        leaderboardbtn_three.setPrefWidth(100);
        gridPane.add(leaderboardbtn_three, 2, 4, 1, 15);
        GridPane.setHalignment(leaderboardbtn_three, HPos.CENTER);
        GridPane.setMargin(leaderboardbtn_three, new Insets(20, 0,20,0));

        mode1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modus = 1;
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                LoginManager loginManager = new LoginManager(nameField.getText(), passwordField.getText());
                loginManager.Login();
                if(loginManager.isAccountTaken() == true){
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "This username is already taken.");
                    return;
                }
                Main main = new Main();
                main.handle(event);
                Stage stage = (Stage) mode1.getScene().getWindow();
                stage.close();
            }
        });

        mode2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modus = 2;
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                LoginManager loginManager = new LoginManager(nameField.getText(), passwordField.getText());
                loginManager.Login();
                if(loginManager.isAccountTaken() == true){
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "This username is already taken.");
                    return;
                }
                Main main = new Main();
                main.handle(event);
                Stage stage = (Stage) mode2.getScene().getWindow();
                stage.close();
            }
        });

        mode3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                modus = 3;
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your name");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                LoginManager loginManager = new LoginManager(nameField.getText(), passwordField.getText());
                loginManager.Login();
                if(loginManager.isAccountTaken() == true){
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "This username is already taken.");
                    return;
                }
                Main main = new Main();
                main.handle(event);
                Stage stage = (Stage) mode3.getScene().getWindow();
                stage.close();
            }
        });



        leaderboardbtn_one.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {

               LeaderBoard leaderBoard = new LeaderBoard();
               leaderBoard.handle_one(event);

           }
        });

        leaderboardbtn_two.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle (ActionEvent event){

                LeaderBoard leaderBoard = new LeaderBoard();
                leaderBoard.handle_two(event);

                }
        });

        leaderboardbtn_three.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle (ActionEvent event){
                LeaderBoard leaderBoard = new LeaderBoard();
                leaderBoard.handle_three(event);
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int mode(){
        return modus;
    }

}