<?php
$servername = "192.168.0.11";
$user = "pi";
$pass = "raspberry";
$dbname = "memeder";

// Create connection
$conn = new mysqli($servername, $user, $pass, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}