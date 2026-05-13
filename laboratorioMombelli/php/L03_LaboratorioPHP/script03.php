<?php

//$prota = file_get_contents("protagonisti.csv");
$prota = file("protagonisti.csv");

foreach ($prota as $linea) {
    $dati = explode(",", $linea);
    echo "Nome: " . $dati[1] . ", Cognome: " . $dati[2]. "\n";
}