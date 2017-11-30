<?php //include config
require_once('config.php');

//Wyciagamy to co przyszło postem
$args = array_keys($_POST)[0];


$data_zamowienia=date("Y-m-d");
$data_odbioru=date('Y-m-d', strtotime("+2 days"));
$data_zwrotu=date($data_odbioru, strtotime("+31 days"));


$stmt = $db->prepare('INSERT INTO  `17524414_test`.`order` (`id_order`,`id_user` ,`id_book` ,`data_zamowienia` ,`data_odbioru` ,`data_zwrotu`) VALUES (NULL, :id_user,  :id_book,  :data_zamowienia, :data_odbioru,  :data_zwrotu) ');
$stmt->bindParam(':id_user', $_POST['id_user'], PDO::PARAM_INT);
$stmt->bindParam(':id_book', $_POST['id_book'], PDO::PARAM_INT);
$stmt->bindParam(':data_zamowienia', $data_zamowienia , PDO::PARAM_INT);
$stmt->bindParam(':data_odbioru', $data_odbioru, PDO::PARAM_INT);
$stmt->bindParam(':data_zwrotu', $data_zwrotu, PDO::PARAM_INT);
$stmt -> execute(); //Wykonujemy zapytanie
$last_id = $db->lastInsertId();



$stmt = $db->prepare('SELECT * FROM  `order` WHERE id_order=:last_id');
$stmt->bindParam(':last_id', $last_id, PDO::PARAM_INT);
$stmt -> execute(); //Wykonujemy zapytanie
$results=$stmt->fetchAll(PDO::FETCH_ASSOC);
$json=json_encode($results); //Enkodujemy wynik w JSONa
echo $json; //I odpalamy
echo "\r\n";
