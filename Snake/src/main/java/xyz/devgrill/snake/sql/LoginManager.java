package xyz.devgrill.snake.sql;
import xyz.devgrill.SQLManager;
import xyz.devgrill.utils.Manager;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LoginManager {
    private final Manager sqlManager = SQLManager.create("mysql-56556-0.cloudclusters.net", "12540", "Snake", "admin", "bPSHZTPa");
    private final String Name;
    private final String password;
    private static int passwordhash;
    private static String passwordHash;
    private static String username;
    private static boolean accountTaken = false;


    public LoginManager(String name, String Password){
        this.Name = name;
        this.password = Password;
    }

    public void Login(){
        Map<Integer, String> hashedStrings = new HashMap<Integer, String>();
        passwordhash = password.hashCode();
        hashedStrings.put(passwordhash, password);
        passwordHash = Integer.toString(passwordhash);
        sqlManager.createQuery("CREATE TABLE IF NOT EXISTS accounts(username varchar(50), passwordhash varchar(200))");
        try{
            sqlManager.createQuery("SELECT COUNT(*) AS rowcount FROM accounts WHERE username = \"" + Name + "\"");
            sqlManager.result.next();
            int count = sqlManager.result.getInt("rowcount");
            sqlManager.result.close();
            if (count == 0){
                username = Name;
                sqlManager.createQuery("INSERT INTO accounts(username, passwordhash) values (\"" + Name + "\", \"" + passwordHash + "\")");
            }else {
                sqlManager.createQuery("SELECT COUNT(*) AS rowcount FROM accounts WHERE username = \"" + Name + "\" and passwordhash = " + passwordHash);
                sqlManager.result.next();
                count = sqlManager.result.getInt("rowcount");
                sqlManager.result.close();
                if(count == 1){
                    accountTaken = false;
                    username = Name;
                }else{
                    accountTaken = true;
                }
            }
        } catch (SQLException e) {
        }

    }

    public boolean isAccountTaken(){
        return accountTaken;
    }

    public String username(){
        return username;
    }


}
