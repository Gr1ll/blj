<?php
$pdo = new PDO('mysql:host=mysql2.webland.ch;dbname=d041e_dagomez', 'd041e_dagomez', '54321_Db!!!', [
    PDO::ATTR_ERRMODE            => PDO::ERRMODE_EXCEPTION,
    PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8',
]);

$stmt = $pdo->query('SELECT description, url from urls order by description asc');
foreach ($stmt->fetchAll() as $x){
    $name = $x['description'];
    $url = $x['url'];
    echo "<a href='$url'>$name</a>";
    echo "&nbsp&nbsp&nbsp";
}