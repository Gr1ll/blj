<?php
header('Content-Type: application/json');
$pdo = new PDO('mysql:host=localhost;dbname=blog', 'root', '');
$statement = $pdo->prepare("SELECT * FROM `posts` ORDER BY date DESC");
$statement->execute();
$data = $statement->fetchAll(PDO::FETCH_ASSOC);
$comments = [];
$thedata = [];
$finaljson = [];
foreach ($data as $item) {
    $id = $item['id'];
    $thestm = $pdo->query("SELECT * FROM `comments` where blogid = '$id'");
    foreach ($thestm->fetchAll() as $value) {
        $row = array();
        $row['id'] = $value['blogid'];
        $row['cusername'] = $value['username'];
        $row['comment'] = $value['comment'];
        array_push($comments, $row);
    }
}

function merge_two_arrays($comments, $thedata)
{
    $data = array();
    $arrayAB = array_merge($comments, $thedata);
    foreach ($arrayAB as $value) {
        $id = $value['id'];
        if (!isset($data[$id])) {
            $data[$id] = array();
        } else {

        }
        $data[$id] = array_merge($data[$id], $value);
    }
    return $data;
}

$master_array = merge_two_arrays($comments, $thedata);
echo json_encode($master_array);

