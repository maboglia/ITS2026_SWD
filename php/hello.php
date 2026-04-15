<?php


// Questo è un semplice script PHP che stampa "Hello, World!" a schermo.
/**/
$saluto = "Hello, World!"; //commento in linea
echo $saluto;




//la variabile in php si introduce col simbolo del $


//costante

define("PI", 3.14); //definisco una costante
echo PI; //stampa il valore della costante

//PI = 7; //non è possibile modificare il valore di una costante, questo genererà un errore

$saluto = "Ciao, Mondo!"; //assegno un nuovo valore alla variabile $saluto
$saluto = true;


if(5 > 4) {
    echo "5 è maggiore di 4";
} else {
    echo "5 non è maggiore di 4";
}

for($i = 0; $i < 5; $i++) {
    echo "Il valore di i è: " . $i . "\n";
}