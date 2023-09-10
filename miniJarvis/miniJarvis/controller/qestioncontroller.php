<?php
$user = 'username';
$password = 'password';
$database = 'database';
$pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);

if(isset($_POST['question']) and isset($_POST['anwser'])){
    $qestion = $_POST['question'];
    $answer = $_POST['anwser'];

    $stmt = $pdo->prepare("INSERT INTO `questions`(`keywords`) VALUES ('$qestion')");
    $stmt->execute();

    $stmt = $pdo->prepare("INSERT INTO `anwsers`(`anwser`) VALUES ('$answer')");
    $stmt->execute();
}