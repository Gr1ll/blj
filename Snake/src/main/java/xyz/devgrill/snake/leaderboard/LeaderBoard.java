package xyz.devgrill.snake.leaderboard;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import xyz.devgrill.snake.sql.ScoreManager;

public class LeaderBoard{

    public void handle_one(ActionEvent event) {
        ScoreManager sm = new ScoreManager("Username", 0);
        String[] top = sm.Leaderboard_one();
        Text title = new Text();
        title.setText("Leaderboard:");
        title.setX(80);
        title.setY(50);
        title.setFont(new Font("", 40));

        Text first = new Text();
        first.setText("1: " + top[0] + " with " + top[1] + " Points");
        first.setX(80);
        first.setY(150);
        first.setFont(new Font("", 20));

        Text second = new Text();
        second.setText("2: " + top[2] + " with " + top[3] + " Points");
        second.setX(80);
        second.setY(190);
        second.setFont(new Font("", 20));

        Text third = new Text();
        third.setText("3: " + top[4] + " with " + top[5] + " Points");
        third.setX(80);
        third.setY(230);
        third.setFont(new Font("", 20));

        Text fourth = new Text();
        fourth.setText("4: " + top[6] + " with " + top[7] + " Points");
        fourth.setX(80);
        fourth.setY(270);
        fourth.setFont(new Font("", 20));

        Text fifth = new Text();
        fifth.setText("5: " + top[8] + " with " + top[9] + " Points");
        fifth.setX(80);
        fifth.setY(310);
        fifth.setFont(new Font("", 20));

        Group root = new Group(title, first, second, third, fourth, fifth);
        Scene scene = new Scene(root, 400, 400);
        Stage stage = new Stage();
        stage.setTitle("Top 5 leaderboard");
        stage.setScene(scene);
        stage.show();
    }

    public void handle_two(ActionEvent event) {
        ScoreManager sm = new ScoreManager("Username", 0);
        String[] top = sm.Leaderboard_two();
        Text title = new Text();
        title.setText("Leaderboard:");
        title.setX(80);
        title.setY(50);
        title.setFont(new Font("", 40));

        Text first = new Text();
        first.setText("1: " + top[0] + " with " + top[1] + " Points");
        first.setX(80);
        first.setY(150);
        first.setFont(new Font("", 20));

        Text second = new Text();
        second.setText("2: " + top[2] + " with " + top[3] + " Points");
        second.setX(80);
        second.setY(190);
        second.setFont(new Font("", 20));

        Text third = new Text();
        third.setText("3: " + top[4] + " with " + top[5] + " Points");
        third.setX(80);
        third.setY(230);
        third.setFont(new Font("", 20));

        Text fourth = new Text();
        fourth.setText("4: " + top[6] + " with " + top[7] + " Points");
        fourth.setX(80);
        fourth.setY(270);
        fourth.setFont(new Font("", 20));

        Text fifth = new Text();
        fifth.setText("5: " + top[8] + " with " + top[9] + " Points");
        fifth.setX(80);
        fifth.setY(310);
        fifth.setFont(new Font("", 20));

        Group root = new Group(title, first, second, third, fourth, fifth);
        Scene scene = new Scene(root, 400, 400);
        Stage stage = new Stage();
        stage.setTitle("Top 5 leaderboard");
        stage.setScene(scene);
        stage.show();
    }

    public void handle_three(ActionEvent event) {
        ScoreManager sm = new ScoreManager("Username", 0);
        String[] top = sm.Leaderboard_three();
        Text title = new Text();
        title.setText("Leaderboard:");
        title.setX(80);
        title.setY(50);
        title.setFont(new Font("", 40));

        Text first = new Text();
        first.setText("1: " + top[0] + " with " + top[1] + " Points");
        first.setX(80);
        first.setY(150);
        first.setFont(new Font("", 20));

        Text second = new Text();
        second.setText("2: " + top[2] + " with " + top[3] + " Points");
        second.setX(80);
        second.setY(190);
        second.setFont(new Font("", 20));

        Text third = new Text();
        third.setText("3: " + top[4] + " with " + top[5] + " Points");
        third.setX(80);
        third.setY(230);
        third.setFont(new Font("", 20));

        Text fourth = new Text();
        fourth.setText("4: " + top[6] + " with " + top[7] + " Points");
        fourth.setX(80);
        fourth.setY(270);
        fourth.setFont(new Font("", 20));

        Text fifth = new Text();
        fifth.setText("5: " + top[8] + " with " + top[9] + " Points");
        fifth.setX(80);
        fifth.setY(310);
        fifth.setFont(new Font("", 20));

        Group root = new Group(title, first, second, third, fourth, fifth);
        Scene scene = new Scene(root, 400, 400);
        Stage stage = new Stage();
        stage.setTitle("Top 5 leaderboard");
        stage.setScene(scene);
        stage.show();
    }
}