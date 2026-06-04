<?php

//Esercizio 14 – Visualizzare dati in una tabella

$fileremoto = "https://raw.githubusercontent.com/maboglia/ProgrammingResources/refs/heads/master/tabelle/games/games.csv";
$content =file_get_contents($fileremoto);

echo '<table>';
foreach (explode("\n", $content) as $line) {
    echo '<tr>';
    foreach (explode(",", $line) as $key => $value) {
        if($key == 0){
            $value = "<a target = '_blank' href = 'https://www.google.com/search?q=". $value."'>".$value."</a>";
        }
        echo '<td>' . $value . '</td>';
    }
    echo '</tr>';
}
echo '</table>';


