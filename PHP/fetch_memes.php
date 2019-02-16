<?php
include("connection.php");

if (isset($_POST["amount"])){
    $amount = $_POST["amount"];


    $sql = "SELECT * FROM memes LIMIT " . $amount;
    $result = $conn->query($sql);
    $memesArray = [];

    if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()) {
            array_push($memesArray, $row);
        }
    } else {
        echo "Not found";
    }
    echo json_encode($memesArray);

    $conn->close();

}

if (isset($_POST["ID"])){
    $id = $_POST["ID"];

    $sql = "SELECT * FROM memes WHERE ID='" . $id . "'";
    $result = $conn->query($sql);
    $currRow = [];
    if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()) {
            $currRow = $row;
        }
    } else {
        echo "Not found";
    }
    echo json_encode($currRow);
    
    $conn->close();
}
