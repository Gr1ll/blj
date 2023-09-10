<?php

function getperms() {
$user = 'username';
$password = 'password';
$database = 'database';
    $pdo = new PDO('mysql:host=h198601.web3.servicehoster.ch;dbname=' . $database, $user, $password, [
        PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
        PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
        PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
    ]);

    $name = $_SESSION['username'];
    $stmt = $pdo->query("SELECT `permission` FROM `user` WHERE `username` = '$name'");
    foreach ($stmt->fetchAll() as $item) {
        $permissionlevel = $item['permission'];
        if ($permissionlevel >= 8) {
            return 1;
        }else{
            return 0;
        }
    }
}