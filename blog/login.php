<?php
$user = 'username';
$password = 'password';
$database = 'database';

$pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);
?>

<html>
<head>
    <link href="styles/login/style.css" rel="stylesheet">
</head>
<body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Log In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Register</label>
        <div class="login-form">
            <form name="login" action="" method="post">
                <input type="hidden" name="formname" value="login"/>
                <div class="sign-in-htm">
                    <div class="group">
                        <label for="user" class="label">Username</label>
                        <input id="user" type="text" class="input" name="username">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <input id="pass" type="password" class="input" data-type="password" name="password">
                    </div>
                    <div class="hr"></div>
                    <div class="group">
                        <a href="index.php">Home</a>
                    </div>
                    <div class="group">
                        <input type="submit" id="login" class="button" value="Sign In">
                    </div>
                </div>
            </form>
            <form name="register" action="" method="post">
                <input type="hidden" name="formname" value="register"/>
                <div class="sign-up-htm">
                    <div class="group">
                        <label for="user" class="label">Username</label>
                        <input id="user" type="text" class="input" name="username">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">Password</label>
                        <input id="pass" type="password" class="input" data-type="password" name="password">
                    </div>
                    <div class="group">
                        <input type="submit" id="register" class="button" value="Sign Up">
                    </div>
                    <div class="hr"></div>
                    <div class="group">
                        <a href="index.php">Home</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<?PHP
if($_SERVER['REQUEST_METHOD'] === 'POST') {
    $fname = $_POST['formname'];
    if($fname == "login"){
        htmlspecialchars($name = $_POST['username']);
        $userpassword = $_POST['password'];
        $stmt = $pdo->query('SELECT * FROM `user`');
        foreach($stmt->fetchAll() as $x) {
            $finalname = $x['username'];
            $finalhash = $x['passwordhash'];
            if(password_verify($userpassword, $finalhash) && $name == $finalname){
                echo "nice";
                session_start();
                $_SESSION['loggedin'] = true;
                $_SESSION['username'] = $name;
                print_r($_SESSION);
                session_write_close();
                break;
            }
        }
    }
    if($fname == "register"){
        htmlspecialchars($name = $_POST['username']);
        $userpassword = $_POST['password'];
        $stmt = $pdo->query("SELECT * FROM `user` WHERE `username` = '$name'");
        if(empty($stmt->fetchAll())){
            $passwordhash = password_hash($userpassword, PASSWORD_DEFAULT);
            $stmt = $pdo->query("INSERT INTO `user`(`username`, `passwordhash`) VALUES ('$name', '$passwordhash')");
            echo "successfully registered";
        }else{
            echo "This username is already taken. Please try a new one.";
        }
        if (!file_exists("./@$name")) {
            mkdir("./@$name", 0777, true);
            copy('./demo/user/index.php', "./@$name/index.php");
        }
    }
}
?>
</body>
</html>