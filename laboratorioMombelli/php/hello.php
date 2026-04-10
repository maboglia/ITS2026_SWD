<?php

// Commento in linea
$saluto = "Hello, World!"; // la variabile si introduce con il simbolo del $



echo $saluto;
/*
Commento su più righe
*/ 

//costante oltre 8 mila funzioni predefinite

define("PI", 3.14);
echo PI;

// PI = 3.14159; // non è possibile modificare il valore di una costante

$saluto = "Ciao, Mondo!";
$saluto = true;


if(5 > 4) {
    echo "5 è maggiore di 4";
} else {
    echo "5 non è maggiore di 4";
}

for($i = 0; $i < 5; $i++) {
    echo "Il numero è: " . $i . "\n";
}