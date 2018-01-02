<?php //include config
require_once('config.php');
// imie, nazwisko, saldo, suma wypożycoznych ksiazek ogolnie i ile obecnie
//Po username
//Wyciagamy to co przyszło postem

/*
Zapytania SQL:
- ogólna ilość wypożyczonych książek na podstawie username: SELECT count(*) FROM  `order`  WHERE  `id_user` IN (SELECT  `id_user` FROM  `users` WHERE  `username` LIKE  'admin')
- obecna ilość wypożyczonych książek na podstawie username: SELECT count(*) FROM  `order` WHERE  `data_zwrotu` >= CURDATE( ) AND  `data_odbioru` <= CURDATE( ) AND  `id_user` IN (SELECT  `id_user` FROM  `users` WHERE  `username` LIKE  'dudel')
- wyciągnięcie imię, nazwisko, saldo, suma obecnie, suma ogolnie: SELECT imie, nazwisko, saldo, obecnie, ogolnie FROM (SELECT COUNT( * ) AS obecnie FROM  `order` WHERE  `data_zwrotu` >= CURDATE( ) AND  `data_odbioru` <= CURDATE( ) AND  `id_user` IN (SELECT  `id_user` FROM  `users` WHERE  `username` LIKE  'dudel')) AS obecnie, (SELECT COUNT( * ) AS ogolnieFROM  `order` WHERE  `id_user` IN (SELECT  `id_user` FROM  `users` WHERE  `username` LIKE  'dudel')) AS ogolnie, (SELECT imie, nazwisko, saldo FROM  `users` WHERE  `username` LIKE  'dudel' ) AS dane
*/
$stmt = $db->prepare('SELECT imie, nazwisko, saldo, obecnie, ogolnie FROM ( SELECT COUNT( * ) AS obecnie  FROM  `order`   WHERE  `data_zwrotu` >= CURDATE( )   AND  `data_odbioru` <= CURDATE( )   AND  `id_user`   LIKE :id_user) AS obecnie, (  SELECT COUNT( * ) AS ogolnie  FROM  `order`   WHERE  `id_user`   LIKE :id_user) AS ogolnie, (  SELECT imie, nazwisko, saldo  FROM  `users`   WHERE  `id_user` LIKE  :id_user) AS dane');
$stmt->bindParam(':id_user', $_POST["id_user"], PDO::PARAM_INT);
$stmt -> execute(); //Wykonujemy zapytanie
$results=$stmt->fetchAll(PDO::FETCH_ASSOC);

$json=json_encode($results); //Enkodujemy wynik w JSONa
echo $json; //I odpalamy
#echo "\r\n";

