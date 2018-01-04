<?php //include config
require_once('config.php');

//Wyciagamy to co przyszło postem
$args = array_keys($_POST)[0];


//W zaleznosci do przyszlo budujemy zapytanie SQL:
switch ($args) {
    case 'id':
        $stmt = $db->prepare('SELECT * FROM news WHERE news_id like :get_news_id');
        $stmt->bindParam(':get_news_id', $_POST['id'], PDO::PARAM_INT);
        break;
	case 'title':
		$stmt = $db->prepare('SELECT news_id FROM news WHERE news_title like :get_news_title');
		$stmt->bindParam(':get_news_title', $_POST['title'], PDO::PARAM_INT);
		break;
	case 'wszystko':
	    $stmt = $db->prepare('SELECT * FROM news');
        break;


}


$stmt -> execute(); //Wykonujemy zapytanie
$results=$stmt->fetchAll(PDO::FETCH_ASSOC);

$json=json_encode($results); //Enkodujemy wynik w JSONa
echo $json; //I odpalamy
//echo "\r\n";
