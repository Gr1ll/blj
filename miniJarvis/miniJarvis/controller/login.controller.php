<?php
$user = 'username';
$password = 'password';
$database = 'database';
$pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);

$found = false;

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $fname = $_POST['formname'];
    if ($fname == "login") {
        htmlspecialchars($name = $_POST['username']);
        $userpassword = $_POST['password'];
        $stmt = $pdo->query('SELECT * FROM `user`');
        foreach ($stmt->fetchAll() as $x) {
            $finalname = $x['username'];
            $finalhash = $x['passwordhash'];
            if (password_verify($userpassword, $finalhash) && $name == $finalname) {
                session_start();
                $_SESSION['loggedin'] = true;
                $_SESSION['username'] = $name;
                session_write_close();
                $found = true;
                echo ("<script>window.location.href='index.php?page=index'</script>");
                break;
            }else{

            }
        }
        if(!$found){
            array_push($Errors, "Wrong username or password!");
        }
    }
    if ($fname == "register") {
        htmlspecialchars($name = $_POST['username']);
        htmlspecialchars($email = $_POST['email']);
        $userpassword = $_POST['password'];
        if (filter_var($email, FILTER_VALIDATE_EMAIL) and !empty($name) and !empty($userpassword)) {
            $stmt = $pdo->query("SELECT `username` FROM `user` WHERE `username` = '$name'");
            if (empty($stmt->fetchAll()) and strlen($name) <= 11) {
                $passwordhash = password_hash($userpassword, PASSWORD_DEFAULT);
                $stmt = $pdo->query("INSERT INTO `user`(`username`, `email`, `passwordhash`) VALUES ('$name','$email','$passwordhash')");
                echo "<script>alert('Successfully registered.')</script>";
            } else {
                //add Errors to the array
                array_push($Errors, "username already taken or too long.");
            }
        } else {
            //add Errors to the array
            array_push($Errors, "Wrong Email or empty username / password");
        }
    }
}