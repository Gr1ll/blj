<?php
$user = 'username';
$password = 'password';
$database = 'database';
$pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    session_start();
    if (!empty($_SESSION)) {
        $name = $_SESSION['username'];
        $oldpassword = htmlspecialchars($_POST['old'] ?? '');
        $newpassword = htmlspecialchars($_POST['new'] ?? '');
        $newpasswordtwo = htmlspecialchars($_POST['newtwo'] ?? '');
        $stmt = $pdo->prepare("SELECT * FROM `user` WHERE username = '$name'");
        $stmt->execute();
        foreach($stmt->fetchAll() as $x) {
            $finalhash = htmlspecialchars($x['passwordhash']);
        }
        if($newpassword == $newpasswordtwo){
            if(password_verify($oldpassword, $finalhash)){
                $newpasswordhash = password_hash($newpasswordtwo, PASSWORD_DEFAULT);
                $stmt = $pdo->prepare("UPDATE `user` SET `passwordhash`='$newpasswordhash' WHERE username = '$name'");
                $stmt->execute();
                echo "<script>alert('Passwords changed sucessfully')</script>";
                $_SESSION['loggedin'] = false;
                $_SESSION['username'] = "Not logged in";
                echo "<script type='text/javascript'>window.location = './login.php';</script>";
            }
        }else{
            echo "<script>alert('Passwords does not match')</script>";
        }
    }
    session_write_close();
}
?>
<form name='register' action='' method='post'>
    <input type='hidden' name='formname' value='change'/>
    <div class='sign-up-htm'>
        <div class='group'>
            <label for='user' class='label'>old password</label>
            <input id='old' type='password' class='input' name='old'>
        </div>
        <div class='group'>
            <label for='pass' class='label'>new password</label>
            <input id='new' class='input' type='password' name='new'>
        </div>
        <div class='group'>
            <label for='pass' class='label'>new password</label>
            <input id='newtwo' class='input' type='password' name='newtwo'>
        </div>
        <div class='group'>
            <input type='submit' id='register' class='button' value='change'>
        </div>
        <div class='hr'></div>
        <div class='group'>
            <br>
            <a href='./index.php'>Home</a>
        </div>
    </div>
</form>