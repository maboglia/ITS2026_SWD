<?php

$url = "https://raw.githubusercontent.com/maboglia/ProgrammingResources/refs/heads/master/tabelle/libri/Biblioteca.csv";

//$books_file = file_get_contents($url);
$books_file = file($url);

//var_dump($books_file);

//print_r($books_file);

$output = "";

$ripetitions = 20;
$output = "";

foreach ($books_file as $row) {
    $dati = explode(",", $row);
    $output .= "addBook(new Book(\"" . trim(str_replace("\"", "", $dati[2])) . "\",";
    $output .= "\"" . trim(str_replace("\"", "", $dati[1])) . "\",";
    $output .= "" . (is_int(trim($dati[4])) ? trim($dati[4]) : 2026) . "));\n";

}

file_put_contents("books.php", "{\n\n" . $output . "\n}");
    //$ripetitions--;
    //if($ripetitions <= 0) break; 


