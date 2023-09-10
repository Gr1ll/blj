package xyz.devgrill.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import xyz.devgrill.snake.register.Register;
import xyz.devgrill.snake.sql.LoginManager;
import xyz.devgrill.snake.sql.ScoreManager;

//
//RUN:
//java --module-path "C:\Program Files\Java\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml,javafx.swing -jar Snake.jar
//
//Author: DevGrill
//

public class Main implements EventHandler<ActionEvent> {

    static int speed = 5;
    static int score = -1;
    static String username;
    static int foodcolor = 0;
    static int wallcolor = 0;
    static int width = 20;
    static int height = 20;
    static int foodX = 0;
    static int foodY = 0;
    static int wallX = 0;
    static int wallY = 0;
    static int cornersize = 25;
    static List<Corner> snake = new ArrayList<>();
    static Dir direction = Dir.left;
    static boolean gameOver = false;
    static Random rand = new Random();
    static boolean wait = true;
    static boolean launch = true;
    static int count = 0;
    static String name;
    static boolean gameIsOver;
    static int highscore;
    static int modus;
    static int mode;
    static boolean newrect = false;
    VBox root = new VBox();
    Pane pane = new Pane();
    static int[] xx = new int[90];
    static int[] yy = new int[90];
    Rectangle rectangle;
    Color rectangleColor;
    boolean now = false;
    int anz = 0;
    static Rectangle rec[] = new Rectangle[900];



    @Override
        public void handle(ActionEvent event) {
            mode = Register.mode();
            Stage newWindow = new Stage();
            snake(newWindow, mode);
            LoginManager lm = new LoginManager("Name", "Password");
            name = lm.username();
        }

    public enum Dir {
        left, right, up, down
    }

    public static class Corner {
        int x;
        int y;

        public Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    public void snake(Stage primaryStage, int mode) {
        modus = mode;
        rectangle = new Rectangle();
        try {
            newFood();
            Canvas c = new Canvas(width * cornersize, height * cornersize);
            GraphicsContext gc = c.getGraphicsContext2D();
            root.getChildren().add(c);

            new AnimationTimer() {
                long lastTick = 0;

                public void handle(long now) {
                    if (lastTick == 0) {
                        lastTick = now;
                        tick(gc);
                        return;
                    }

                    if (now - lastTick > 1000000000 / speed) {
                        lastTick = now;
                        tick(gc);
                    }
                }

            }.start();

            Scene scene = new Scene(root, width * cornersize, height * cornersize);

            scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
                if(modus == 3){
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    }catch (Exception e){

                        e.printStackTrace();
                    }
                }else if(modus == 2){
                    try {
                        TimeUnit.MILLISECONDS.sleep(120);
                    }catch (Exception e){

                        e.printStackTrace();
                    }
                }
                if (key.getCode() == KeyCode.UP || key.getCode() == KeyCode.W) {
                    if(direction == Dir.down) return;
                    direction = Dir.up;
                }
                if (key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.A) {
                    if(direction == Dir.right) return;
                    direction = Dir.left;
                }
                if (key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.S) {
                    if(direction == Dir.up) return;
                    direction = Dir.down;
                }
                if (key.getCode() == KeyCode.RIGHT || key.getCode() == KeyCode.D) {
                    if(direction == Dir.left) return;
                    direction = Dir.right;
                }
                if(gameOver && key.getCode() == KeyCode.SPACE){
                    speed = 5;
                    score = 0;
                    foodcolor = 0;
                    wallcolor = 0;
                    width = 20;
                    height = 20;
                    for (int i = snake.size() - 1; i >= 3; i--) {
                        snake.remove(i);
                    }
                    snake.get(0).y = 8;
                    snake.get(0).x = 8;
                    count = 0;

                    direction = Dir.left;
                    gameOver = false;
                }
            });

            snake.add(new Corner(width / 2, height / 2));
            snake.add(new Corner(width / 2, height / 2));
            snake.add(new Corner(width / 2, height / 2));

            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setTitle("Snake");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tick(GraphicsContext gc) {
        if(gameIsOver) {
            ScoreManager scoreManager = new ScoreManager(name, score);
            scoreManager.Finish();
            highscore = scoreManager.highScore(modus);
            gameIsOver = false;
        }
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("", 50));
            gc.fillText("GAME OVER", 100, 250);
            gc.fillText("Dein Highscore: ", 100, 300);
            xx = new int[90];
            anz = 0;
            yy = new int [90];
            gc.fillText(Integer.toString(highscore), 100, 350);
            return;
        }

        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }

        int delay;
        long start;
        switch (direction) {
            case up:
                snake.get(0).y--;
                if (snake.get(0).y < 0) {
                    gameOver = true;
                    gameIsOver = true;
                }

                break;
            case down:
                snake.get(0).y++;
                if (snake.get(0).y > 19) {
                    gameOver = true;
                    gameIsOver = true;
                }

                break;
            case left:
                snake.get(0).x--;
                if (snake.get(0).x < 0) {
                    gameOver = true;
                    gameIsOver = true;
                }

                break;
            case right:
                snake.get(0).x++;
                if (snake.get(0).x > width - 1) {
                    gameOver = true;
                    gameIsOver = true;
                }
                break;
        }


        if (foodX == snake.get(0).x && foodY == snake.get(0).y) {
            snake.add(new Corner(-1, -1));
            count++;
            now = true;
            drawRectangle();
            newFood();
        }

        if (modus == 3) {
            for (int i = 0; i <= anz; i++) {
                if (xx[i] != 0 && yy[i] != 0) {
                    if (xx[i] == snake.get(0).x && yy[i] == snake.get(0).y) {
                        gameOver = true;
                        gameIsOver = true;
                        newFood();
                    }
                }
            }
        }

        if(modus == 1 || modus == 3){
            for (int i = 1; i < snake.size(); i++) {
                if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                    gameOver = true;
                    gameIsOver = true;
                }
            }
        }

        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, width * cornersize, height * cornersize);
        int i;
        for (i = 0; i <= anz; i++){
            if(xx[i] != 0 && yy[i] != 0){
                gc.setFill(Color.RED);
                gc.fillRect(xx[i] * cornersize, yy[i] * cornersize, cornersize, cornersize);
            }
        }
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("", 30));
        gc.fillText("Score: " + score, 10, 30);
        gc.fillText("Username: " + name, 160, 30);

        Color cc = Color.WHITE;

        switch (foodcolor) {
            case 0:
                cc = Color.PURPLE;
                break;
            case 1:
                cc = Color.LIGHTBLUE;
                break;
            case 2:
                cc = Color.YELLOW;
                break;
            case 3:
                cc = Color.PINK;
                break;
            case 4:
                cc = Color.ORANGE;
                break;
        }
        gc.setFill(cc);
        gc.fillOval(foodX * cornersize, foodY * cornersize, cornersize, cornersize);
        gc.setFill(Color.WHITE);


        for (Corner c : snake) {
            gc.setFill(Color.LIGHTGREEN);
            gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize - 1, cornersize - 1);
            gc.setFill(Color.GREEN);
            gc.fillOval(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);

        }
    }


    public void drawRectangle(){
        if(now && modus == 3) {
            for (Corner c : snake) {
                if (c.x == wallX && c.y == wallY) {
                    return;
                }
            }
            wallX = rand.nextInt(width);
            wallY = rand.nextInt(height);
            anz++;
            xx[anz] = wallX;
            yy[anz] = wallY;
            now = false;
        }
    }

    public void newFood() {
        start: while (true) {
            foodX = rand.nextInt(width);
            foodY = rand.nextInt(height);

            for (int i = 0; i <= anz; i++) {
                if (xx[i] == foodX && yy[i] == foodY) {
                    newFood();
                }
            }

            for (Corner c : snake) {
                if (c.x == foodX && c.y == foodY) {
                    continue start;
                }
            }
            foodcolor = rand.nextInt(5);
            if(modus != 3){
                speed++;
            }
            score++;
            break;

        }
    }
}