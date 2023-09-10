package xyz.devgrill.snake.sql;

import xyz.devgrill.SQLManager;
import xyz.devgrill.snake.register.Register;
import xyz.devgrill.utils.Manager;


public class ScoreManager {
    private final Manager sqlManager = SQLManager.create("mysql-56556-0.cloudclusters.net", "12540", "Snake", "admin", "bPSHZTPa");
    private final String userId;
    private final int Score;
    private static boolean isOver = false;

    public ScoreManager(String username, int Score){
        this.userId = username;
        this.Score = Score;
    }

    public void Finish(){
        int mode = Register.mode();
        isOver = false;
        if(!isOver) {
            isOver = true;
            if(mode == 1){
                sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_one(username varchar(50), score int)");
                sqlManager.createQuery("INSERT INTO leaderboard_one (username, score) VALUES (\"" + userId + "\",\"" + Score + "\")");
            }
            if(mode == 2){
                sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_two(username varchar(50), score int)");
                sqlManager.createQuery("INSERT INTO leaderboard_two (username, score) VALUES (\"" + userId + "\",\"" + Score + "\")");
            }
            if(mode == 3){
                sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_three(username varchar(50), score int)");
                sqlManager.createQuery("INSERT INTO leaderboard_three (username, score) VALUES (\"" + userId + "\",\"" + Score + "\")");
            }
        }
    }

    public String[] Leaderboard_one(){
        String[] arr = new String[10];
        try {
            sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_one(username varchar(50), score int)");
            sqlManager.createQuery("SELECT * FROM leaderboard_one ORDER BY score DESC LIMIT 5");
            sqlManager.result.next();
            arr[0] = sqlManager.result.getString("username");
            arr[1] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[2] = sqlManager.result.getString("username");
            arr[3] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[4] = sqlManager.result.getString("username");
            arr[5] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[6] = sqlManager.result.getString("username");
            arr[7] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[8] = sqlManager.result.getString("username");
            arr[9] = sqlManager.result.getString("score");
            sqlManager.result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    public String[] Leaderboard_two(){
        String[] arr = new String[10];
        try {
            sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_two(username varchar(50), score int)");
            sqlManager.createQuery("SELECT * FROM leaderboard_two ORDER BY score DESC LIMIT 5");
            sqlManager.result.next();
            arr[0] = sqlManager.result.getString("username");
            arr[1] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[2] = sqlManager.result.getString("username");
            arr[3] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[4] = sqlManager.result.getString("username");
            arr[5] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[6] = sqlManager.result.getString("username");
            arr[7] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[8] = sqlManager.result.getString("username");
            arr[9] = sqlManager.result.getString("score");
            sqlManager.result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    public String[] Leaderboard_three(){
        String[] arr = new String[10];
        try {
            sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_three(username varchar(50), score int)");
            sqlManager.createQuery("SELECT * FROM leaderboard_three ORDER BY score DESC LIMIT 5");
            sqlManager.result.next();
            arr[0] = sqlManager.result.getString("username");
            arr[1] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[2] = sqlManager.result.getString("username");
            arr[3] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[4] = sqlManager.result.getString("username");
            arr[5] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[6] = sqlManager.result.getString("username");
            arr[7] = sqlManager.result.getString("score");
            sqlManager.result.next();
            arr[8] = sqlManager.result.getString("username");
            arr[9] = sqlManager.result.getString("score");
            sqlManager.result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    public int highScore(int mode) {
        int highScore = 0;
        if(mode == 1) {
            try {
                sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_one(username varchar(50), score int)");
                sqlManager.createQuery("select max(score) as 'highScore' from leaderboard_one where username = \"" + userId + "\"");
                sqlManager.result.next();
                highScore = sqlManager.result.getInt("highScore");
                sqlManager.result.close();
                return highScore;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(mode == 2) {
            try {
                sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_three(username varchar(50), score int)");
                sqlManager.createQuery("select max(score) as 'highScore' from leaderboard_two where username = \"" + userId + "\"");
                sqlManager.result.next();
                highScore = sqlManager.result.getInt("highScore");
                sqlManager.result.close();
                return highScore;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(mode == 3) {
            try {
                sqlManager.createQuery("CREATE TABLE IF NOT EXISTS leaderboard_three(username varchar(50), score int)");
                sqlManager.createQuery("select max(score) as 'highScore' from leaderboard_three where username = \"" + userId + "\"");
                sqlManager.result.next();
                highScore = sqlManager.result.getInt("highScore");
                sqlManager.result.close();
                return highScore;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return highScore;
    }
}