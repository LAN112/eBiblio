<?php
    $con = mysqli_connect("localhost", "17524414_test", "M5b!hFqt2yp&", "17524414_test");
    $username = $_POST["username"];
    $password = $_POST["password"];
$statement = mysqli_prepare($con, "SELECT * FROM users WHERE username = ? AND password = ?");
mysqli_stmt_bind_param($statement, "ss", $username, $password);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $userID,$username, $password, $imie, $nazwisko, $saldo, $avatar_filename);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["username"] = $username;
        $response["password"] = $password;
    }

    echo json_encode($response);
?>
