<?php //include config
require_once('config.php');

//Wyciagamy to co przyszło postem
$args = array_keys($_POST)[0];


//W zaleznosci do przyszlo budujemy zapytanie SQL:
switch ($args) {
    case 'id':
        $stmt = $db->prepare('SELECT id_book, tytul, autor, wydawnictwo, rok_wydania, opis, cover_filename FROM book WHERE id_book like :get_id_book');
        $stmt->bindParam(':get_id_book', $_POST['id'], PDO::PARAM_INT);
        break;
    case 'tytul':
        $stmt = $db->prepare('SELECT id_book, tytul, autor, wydawnictwo, rok_wydania, opis, cover_filename FROM book WHERE tytul like ?');
        $stmt->bindValue(1, '%'.$_POST['tytul'].'%');
        break;
    case 'autor':
        $stmt = $db->prepare('SELECT id_book, tytul, autor, wydawnictwo, rok_wydania, opis, cover_filename FROM book WHERE autor like ?');
        $stmt->bindValue(1, '%'.$_POST['autor'].'%');
        break;
    case 'wydawnictwo':
        $stmt = $db->prepare('SELECT id_book, tytul, autor, wydawnictwo, rok_wydania, opis, cover_filename FROM book WHERE wydawnictwo like ?');
        $stmt->bindValue(1, '%'.$_POST['wydawnictwo'].'%');
        break;
    case 'rok_wydania':
        $stmt = $db->prepare('SELECT id_book, tytul, autor, wydawnictwo, rok_wydania, opis, cover_filename FROM book WHERE rok_wydania like :get_rok_wydania');
        $stmt->bindParam(':get_rok_wydania', $_POST['rok_wydania'], PDO::PARAM_INT);
        break;
	case 'liczba':
	    $stmt = $db->prepare('SELECT * FROM book');
        break;
	case 'id_user':
		$stmt = $db->prepare('SELECT * FROM `order` WHERE id_user like :get_id_user');
		$stmt->bindParam(':get_id_user', $_POST['id_user'], PDO::PARAM_INT);
		break;
	case 'saved':
		$stmt = $db->prepare('SELECT * FROM `saved` WHERE id_user like :get_id_user');
		$stmt->bindParam(':get_id_user', $_POST['saved'], PDO::PARAM_INT);
		break;
	case 'id_order':
		$stmt = $db->prepare('SELECT * FROM `order` WHERE id_order like :get_id_order');
		$stmt->bindParam(':get_id_order', $_POST['id_order'], PDO::PARAM_INT);
		break;
	case 'username':
		$stmt = $db->prepare('SELECT id_user FROM users WHERE username like :get_username');
		$stmt->bindParam(':get_username', $_POST['username'], PDO::PARAM_INT);
		break;
	case 'najnowsze':
		$stmt = $db->prepare('SELECT * FROM book ORDER BY id_book DESC LIMIT 5 ');
		break;
		
		


}


$stmt -> execute(); //Wykonujemy zapytanie
$results=$stmt->fetchAll(PDO::FETCH_ASSOC);

$json=json_encode($results); //Enkodujemy wynik w JSONa
echo $json; //I odpalamy
//echo "\r\n";
