<?php

//var_dump($GLOBALS);

//phpinfo();

session_start(); // funzione che fa partire la sessione
$_SESSION["user_logged_in"] = true;
$_SESSION["username"] = "John Doe";

var_dump($_SESSION);

//session_abort();
unset($_SESSION);

//var_dump($_SESSION);
var_dump(session_id());