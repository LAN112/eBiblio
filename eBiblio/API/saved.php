<?php //include config
require_once('config.php');

//Wyciagamy to co przyszło postem
$args = array_keys($_POST)[0];




$stmt = $db->prepare('INSERT INTO  `17524414_test`.`saved` (`saved_id`,`id_user` ,`id_book`) VALUES (NULL, :id_user,  :id_book) ');
$stmt->bindParam(':id_user', $_POST['id_user'], PDO::PARAM_INT);
$stmt->bindParam(':id_book', $_POST['id_book'], PDO::PARAM_INT);
$stmt -> execute(); //Wykonujemy zapytanie
$last_id = $db->lastInsertId();



$stmt = $db->prepare('SELECT * FROM  `saved` WHERE saved_id=:last_id');
$stmt->bindParam(':last_id', $last_id, PDO::PARAM_INT);
$stmt -> execute(); //Wykonujemy zapytanie
$results=$stmt->fetchAll(PDO::FETCH_ASSOC);
$json=json_encode($results); //Enkodujemy wynik w JSONa
echo $json; //I odpalamy
echo "\r\n";
