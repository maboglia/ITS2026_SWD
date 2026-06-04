<?php
// Esercizio 9 - Tabellina del 2 con while

$moltiplicatore = 1;
$numero = 2;

echo '<table border="1">';
echo '<tr><th>Operazione</th><th>Risultato</th></tr>';

while ($moltiplicatore <= 10) {
    echo '<tr>';
    echo '<td>' . $numero . ' x ' . $moltiplicatore . '</td>';
    echo '<td>' . ($numero * $moltiplicatore) . '</td>';
    echo '</tr>';
    $moltiplicatore++;
}

echo '</table>';
?>