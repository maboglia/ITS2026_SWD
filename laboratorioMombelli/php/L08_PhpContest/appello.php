<?php

class Studente {
    private $id;
    private $nome;
    private $cognome;

    public function __construct($id, $nome, $cognome) {
        $this->id = $id;
        $this->nome = $nome;
        $this->cognome = $cognome;
    }

    public function getId() {
        return $this->id;
    }

    public function getNome() {
        return $this->nome;
    }

    public function getCognome() {
        return $this->cognome;
    }

    public function __toString() {
        return "ID: " . $this->id . " - Nome: " . $this->nome . " - Cognome: " . $this->cognome;
    }
}





$studenti = file("studenti.csv"); // puoi leggere qualsiasi file di testo ed importarlo direttamente in un array

$oggettiStudenti = [];

foreach ($studenti as $studente) {
    $dati = explode(",", $studente); // con explode puoi dividere una stringa in un array, specificando il carattere di separazione
    $oggettiStudenti[] = new Studente($dati[0], $dati[1], $dati[2]);
}

$indice = array_rand($oggettiStudenti);

$esercizio = random_int(1,28);

echo $oggettiStudenti[$indice];
echo "Esercizio: " . $esercizio;


//foreach ($studenti as $studente) {
//    $dati = explode(",", $studente); // con explode puoi dividere una stringa in un array, specificando il carattere di separazione
//    $studente = new Studente($dati[0], $dati[1], $dati[2]);
//    echo $studente . "<br>\n";
//}