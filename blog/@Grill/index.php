<?php
$user = 'username';
$password = 'password';
$database = 'database';

$pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);

session_start();
if(!empty($_SESSION)){
    $name = $_SESSION['username'];
    if("@$name" == basename(__DIR__)){
        echo ("
        <form name='register' action='' method='post'>
                <input type='hidden' name='formname' value='post'/>
                <div class='sign-up-htm'>
                    <div class='group'>
                        <label for='user' class='label'>Title</label>
                        <input id='title' type='text' class='input' name='title'>
                    </div>
                    <div class='group'>
                        <label for='pass' class='label'>internet image link</label>
                        <input id='img' class='input' type='text' name='img'>
                    </div>
                    <div class='group'>
                        <label for='pass' class='label'>Description</label>
                        <input id='desc' class='input' type='text' name='desc'>
                    </div>
                    <div class='group'>
                        <input type='submit' id='register' class='button' value='PostIt'>
                    </div>
                    <div class='hr'></div>
                    <div class='group'>
                        <a href='../index.php'>Home</a>
                    </div>
                </div>
            </form>
            <a href='../logout.php'>logout</a>
            <br>
            <a href='../changepw.php'>change password</a>
            <br>
            <a href='../addemail.php'>Add Email</a>
            <br>
            <a href='../deletepost.php'>Delete posts</a>
        ");
    }
}
session_write_close();

//validate

$errorlist = [];

if($_SERVER['REQUEST_METHOD'] === 'POST') {
    htmlspecialchars($title = $_POST['title']);
    htmlspecialchars($img = $_POST['img']);
    htmlspecialchars($desc = $_POST['desc']);
    $title = trim($title);
    $img = trim($img);
    $desc = trim($desc);

    if($title == ''){
        array_push($errorlist,"Empty title");
    }

    if($img == ''){
    }elseif(strpos($img, "http") === false){
        array_push($errorlist,"This image url is not vaild");
    }

    if($desc == ''){
        array_push($errorlist,"Empty description");
    }

    if(empty($errorlist)){
        $stmt = $pdo->query("INSERT INTO `posts`(`username`, `title`, `img`, `beschreibung`) VALUES ('$name', '$title', '$img', '$desc')");
    }else{
        print_r($errorlist);
    }
}
?>
