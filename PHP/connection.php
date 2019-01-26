<?php
$servername = "192.168.0.11";
$user = "pi";
$pass = "raspberry";
$dbname = "memeder";

// Create connection
$conn = new mysqli($servername, $user, $pass, $dbname);
// Check connection
if ($conn->connect_error) {
    $response["success"] = 0;
    $response["message"] = "Connection failed";
    echo json_encode($response);
} else {
    $response["success"] = 1;
    $response["connection Successful"];
    echo json_encode($response);
}