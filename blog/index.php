<?php
session_start();
if(empty($_SESSION)){
    $_SESSION['username'] = "Not logged in";
    $_SESSION['loggedin'] = false;
}

$_SERVER['REMOTE_ADDR'];
$username = $_SESSION['username'];
$isloggedin = $_SESSION['loggedin'];
session_write_close();


$user = 'username';
$password = 'password';
$database = 'database';

$pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);


?>

<html>
<head>
    <link href="styles/index/style.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="grid header">
        <?php
        echo "Welcome to grillonet";
        ?>
    </div>
    <div class="grid menu">
        <?php
        session_start();
        if($username == "Not logged in"){
            echo "<a href='login.php'>Log in to Post</a>";
        }else{
            echo "<a href='./@$username'>post</a>";
        }
        session_write_close();
        ?>
    </div>
    <div class="grid search">
        <?php
        echo "<a href='blj-kollegen.php'>BLJ Kollegen</a>";
        ?>
    </div>
    <div class="grid login">
        <?PHP
        if($isloggedin){
            echo "<a href='/@$username'>Profile</a>";
        }else{
            echo "<a href='login.php'>Login/register</a>";
        }
        ?>
    </div>
    <div class="grid content">

        <?php
        $stmt = $pdo->query('SELECT * FROM `posts` ORDER BY date DESC;');
        foreach($stmt->fetchAll() as $blog) {
            $title = htmlspecialchars($blog['title']);
            $img = htmlspecialchars($blog['img']);
            $desc = htmlspecialchars($blog['beschreibung']);
            $author = htmlspecialchars($blog['username']);
            $date = htmlspecialchars($blog['date']);
            $id = $blog['id'];
            $likes = $blog['likes'];
            echo("
            <div class='post'>
                <p class='title'>$title</p>      
                <img src='$img' class='image' '>      
                <p class='beschreibung'>$desc</p>
                <p class='footer'>Username: $author <br> Created At: $date</p>
                <p class='footer'>Likes: $likes</p>
                <br>
                <form name='like' action='' method='post'>
                    <input type='hidden' name='fname' value='like'/>
                    <input type='hidden' name='id' value='$id'/>
                    <button class='like' type='submit'>like</button>
                </form>
                <form name='comment' action='' method='post'>
                    <input type='hidden' name='fname' value='comment'/>    
                    <input type='hidden' name='id' value='$id'/>        
                    <input name='cmd' type='text'/>
                    <button class='commentbtn' type='submit' value='Sign Up'>comment</button>
                </form>
                <p class='footer'>Comments:</p>
            ");
            $thestm = $pdo->query("SELECT * FROM `comments` where blogid = '$id'");
            foreach ($thestm->fetchAll() as $item){
                $thecomment = htmlspecialchars($item['comment']);
                $theusername = htmlspecialchars($item['username']);
                echo "<p class='thecomment'>$theusername: $thecomment</p>";
            }
            echo "</div> ";

        }
        ?>

        <?PHP
        if($_SERVER['REQUEST_METHOD'] === 'POST') {
            if($isloggedin){
                $fname = $_POST['fname'];
                if($fname == "like"){
                    $theid = $_POST['id'];
                    $blogid = "empty";
                    $stmt = $pdo->query("SELECT likes FROM `posts` where id = '$theid'");
                    foreach ($stmt->fetchAll() as $x){
                        $thelikes = $x['likes']+1;
                    }
                    $stmt = $pdo->query("SELECT id FROM `user` WHERE username = '$username'");
                    foreach ($stmt->fetchAll() as $x){
                        $userid = $x['id'];
                    }
                    $likedposts = [];
                    $stmt = $pdo->query("SELECT * FROM `likes` WHERE userid = '$userid'");
                    foreach ($stmt->fetchAll() as $x){
                        $blogid = $x['blogid'];
                        array_push($likedposts, $blogid);
                    }
                    if(in_array($theid, $likedposts)){

                    }else{
                        $stmt = $pdo->query("UPDATE `posts` SET `likes` = '$thelikes' WHERE id = '$theid'");
                        $stmt = $pdo->query("INSERT INTO `likes` VALUES ('$theid', '$userid')");
                        echo ("
                                <script type='text/javascript'>
                                window.location = './';
                                </script>
                                ");
                    }
                }
                if($fname == "comment"){
                    $theid = $_POST['id'];
                    if(!empty($_POST)){
                        $comment = $_POST['cmd'];
                        $stmt = $pdo->query("INSERT INTO `comments` VALUES ('$theid', '$username', '$comment')");
                        echo ("
                            <script type='text/javascript'>
                            window.location = './';
                            </script>
                          ");
                    }
                }
            }else{
                echo ("
                <script type='text/javascript'>
                alert('Please log in to react with the post');
                </script>
              ");
            }
        }
        ?>
</div>
</body>
</html>
