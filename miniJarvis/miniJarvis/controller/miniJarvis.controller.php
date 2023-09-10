<?php
$user = 'username';
$password = 'password';
$database = 'database';
$pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);

if(isset($_COOKIE["voice"])){
    $voice = $_COOKIE["voice"];
    $done = false;
    $keyword = str_replace(" ", ",", $voice);
    $stmt = $pdo->prepare("select * , match(keywords) against ('$keyword' in boolean mode) as relevance from questions where match(keywords) against ('$keyword' in boolean mode) ORDER BY `relevance` DESC");
    $stmt->execute();
    foreach ($stmt->fetchAll() as $item){
        $anwserid = $item['answerID'];
        $stmt = $pdo->prepare("SELECT anwsers.anwser FROM questions INNER JOIN anwsers ON '$anwserid' = anwsers.anwserid");
        $stmt->execute();
        foreach ($stmt->fetchAll() as $anwser){
            if($done == false){
                $finalanwser = $anwser['anwser'];
                echo "
                <script>
                alert('$finalanwser');
                </script>
                ";
                $done = true;
            }
        }
    }
}