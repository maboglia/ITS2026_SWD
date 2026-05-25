<?php

if (isset($_POST["username"]) && isset($_POST["password"])) {
    $username = $_POST["username"];
    $password = $_POST["password"];

    // In a real application, you would verify the username and password against a database
    if ($username === "admin" && $password === "12345") {
        $_SESSION["logged_in"] = true;
        $_SESSION["username"] = $username;
        header("Location: ?pagina=home");
        exit();
    } else {
        echo "<p style='color:red;'>Invalid username or password</p>";
    }
}




