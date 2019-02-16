<?php
$servername = "100.67.178.217";
$user = "pi";
$pass = "raspberry";
$dbname = "memeder";

// Create connection
$conn = new mysqli($servername, $user, $pass, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}