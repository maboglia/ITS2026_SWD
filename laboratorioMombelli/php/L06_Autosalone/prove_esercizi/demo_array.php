<?php

$frutti = array("mela", "banana", "arancia", "pera");

$verdure = array("carota", "pomodoro", "zucchina");

array_push($frutti, "kiwi", "fragola");

$verdure[] = "lattuga";

$piatti = [
    [
    "frutti" => $frutti[0],
    "verdure" => $verdure[0]
    ],
    [
    "frutti" => $frutti[2],
    "verdure" => $verdure[3]
    ],
    [
    "frutti" => $frutti[1],
    "verdure" => $verdure[4]
    ],
];

for ($i = 0; $i < count($piatti); $i++) {
    echo "Piatti " . ($i + 1) . ": " . $piatti[$i]["frutti"] . " e " . $piatti[$i]["verdure"] . "\n";
}

for ($i = 0; $i < count($frutti); $i++) {
    echo $frutti[$i] . "\n";
}

foreach ($verdure as $verdura) { // prima gli passo la collezione, poi la variabile che conterrà ogni elemento
    echo $verdura . "\n";
}

