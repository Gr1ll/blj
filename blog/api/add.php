<?php
// JSON auslesen

 $url = "http://localhost/api/api.php";
 $json = file_get_contents($url);

$json = json_decode($json, true);

foreach($json as $blog) {
    $blogid = htmlspecialchars($blog['blogid']);
    $username = htmlspecialchars($blog['cusername']);
    $usercomment = htmlspecialchars($blog['comment']);
    $title = htmlspecialchars($blog['title']);
    $img = htmlspecialchars($blog['img']);
    $desc = htmlspecialchars($blog['beschreibung']);
    $author = htmlspecialchars($blog['username']);
    $date = htmlspecialchars($blog['date']);
    $id = $blog['id'];
    $likes = $blog['likes'];
    if($blogid == $id){
        $thecomment = "$username:   $usercomment";
        echo "<div>";
        echo("    
            <link href='style.css' rel='stylesheet'>
            <div class='post'>
                <p class='title'>$title</p>      
                <img src='$img' class='image' '>      
                <p class='beschreibung'>$desc</p>
                <p class='footer'>Username: $author <br> Created At: $date</p>
                <p class='footer'>Likes: $likes</p>
                <p class='footer'>comments:</p>
                <p class='footer'>$thecomment</p>
                <br>
            ");
                echo "</div> ";
    }else{
        echo "<div>";
        echo("    
            <link href='style.css' rel='stylesheet'>
            <div class='post'>
                <p class='title'>$title</p>      
                <img src='$img' class='image' '>      
                <p class='beschreibung'>$desc</p>
                <p class='footer'>Username: $author <br> Created At: $date</p>
                <p class='footer'>Likes: $likes</p>
                <p class='footer'>comments:</p>
                <br>
            ");
        echo "</div> ";
    }

}
?>