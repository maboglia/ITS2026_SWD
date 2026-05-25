<?php

session_start();

echo "<h1>Benvenuto al nostro autosalone!</h1>";

if (
    isset($_POST["username"]) &&
    isset($_POST["password"])
) {

    $username = $_POST["username"];
    $password = $_POST["password"];

    if ($username == "admin" && $password == "12345") {

        $_SESSION["user_logged_in"] = true;
        $_SESSION["username"] = $username;

        echo "<h1>Autosalone</h1>";
        echo "<p>Benvenuto, " . $_SESSION["username"] . "!</p>";

    } else {

        echo "Username o password errati!";

    }

} else {

    // Form shown only before login
    echo "
    <form method='POST'>

        <h2>Login</h2>

        Username:
        <input type='text' name='username'>

        <br><br>

        Password:
        <input type='password' name='password'>

        <br><br>

        <button type='submit'>Login</button>

    </form>
    ";
}