<?php

$symbols = ['rock', 'scissor', 'paper']; // array
//$symbols = array('rock', 'scissor', 'paper'); // array 
// posso andare a capo e identare come voglio, tanto l'istruzione finisce quando trova il ;
//$symbols[] = 'lizard'; // aggiungo un elemento alla fine dell'array
//array_push($symbols, 'spock'); // aggiungo un elemento alla fine dell'array

//$player1 = choice($symbols);
//$player2 = choice($symbols);

function choice($symbols) {
    $index = rand(0, count($symbols) - 1); // genero un numero casuale tra 0 e la lunghezza dell'array - 1
    return $symbols[$index]; // restituisco l'elemento dell'array corrispondente all'indice generato
}

//echo "Player 1: $player1\n";
//echo "Player 2: $player2\n";
//
//print($player1 . ' vs ' . $player2 . "\n"); // concatenazione di stringhe


function determineWinner($player1, $player2) {
    if ($player1 === $player2) {
        return 'Draw';
    } elseif (
        ($player1 === 'rock' && $player2 === 'scissor') ||
        ($player1 === 'scissor' && $player2 === 'paper') ||
        ($player1 === 'paper' && $player2 === 'rock')
    ) {
        return 'Player 1 wins';
    } else {
        return 'Player 2 wins';
    }
}

//$result = determineWinner($player1, $player2);
//echo "Result: {$result}\n";


?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
        }
        .human, .machine, .result {
            margin: 20px 0;
        }

    </style>
    <title>Document</title>
</head>
<body>
    <div class="container">
        <h1>Rock, Paper, Scissor</h1>
    </div>
        <div class="human">
            <a href="?player1=rock">Rock</a>
            <a href="?player1=scissor">Scissor</a>
            <a href="?player1=paper">Paper</a>
        </div>
        <div class="human-choice">
            <?php
                $player1 = $_GET['player1'] ?? choice($symbols); // operatore ternario condensato ??
                echo "Player choice: $player1";
            ?>
        </div>
        <div class="machine">
            <?php
                $player2 = choice($symbols);
                echo "Machine choice: $player2";
            ?>
        </div>

        <div class="result">
            <?php
                $result = determineWinner($player1, $player2);
                echo "Result: {$result}";
            ?>
        </div>
    </div>
</body>
</html>