<?php
//Turbo dane do bazy
//error_reporting(0);
$salt='v4oxzixs2q';
//ob_start();
session_start();
//database credentials
define('DBHOST', 'michalbielejewski.home.pl');
define('DBUSER', '17524414_test');
define('DBPASS', 'M5b!hFqt2yp&');
define('DBNAME', '17524414_test');
$db = new PDO("mysql:host=".DBHOST.";charset=utf8;dbname=".DBNAME, DBUSER, DBPASS);
$db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
$db->exec("set names utf8");
//set timezone
date_default_timezone_set('Europe/Warsaw');
