<?php
header('Content-Type: application/json');
$pdo = new PDO('mysql:host=localhost;dbname=blog', 'root', '');
$statement = $pdo->prepare("SELECT * FROM `posts` ORDER BY date DESC");
$statement->execute();
$data = $statement->fetchAll(PDO::FETCH_ASSOC);
echo json_encode($data);