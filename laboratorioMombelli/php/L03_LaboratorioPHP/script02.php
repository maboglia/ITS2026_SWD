<?php
/*
Esercizio 2: Variabili e Operazioni Aritmetiche
Crea uno script PHP che dichiara due variabili numeriche e stampa la somma, la differenza, il prodotto e il quoziente.
*/
$a = 10;
$b = 5;

echo "La somma di $a e $b è : ".($a+$b);
echo "\nLa differenza di $a e $b è : ".($a-$b);
echo "\nIl prodotto di $a e $b è : ".($a*$b);
echo "\nIl quoziente di $a e $b è : ".($a/$b);

/*
Esercizio 3: Condizioni
Scrivi uno script PHP che controlla se una variabile numerica è positiva, negativa o zero e stampa un messaggio appropriato.
*/

$numerica = 7;
$giudizio = 0;
echo "\n\n";
//if($numerica > 7){
    //$giudizio = 'Molto buono';
    //    echo 'Il valore della var $numerica è > 0';
//}elseif($numerica == 0){
     //$giudizio = 'Discreto';
//    echo 'Il valore della var $numerica è = 0';
//}else{
    //$giudizio = 'Sufficiente';
//    echo 'Il valore della var $numerica è < 0';
//}

// si userà molto raramente
switch ($numerica){
    case 0:
        echo 'Il valore della var $numerica è = 0';
        break;
    case 1:
        echo 'Il valore della var $numerica è = 1';
        break;
    case -1:
        echo 'Il valore della var $numerica è = -1';
        break;

} // lo switch non ha un valore di return, mentre il match è più potente

