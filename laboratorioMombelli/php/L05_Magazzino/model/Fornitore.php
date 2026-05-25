<?php

class Fornitore {
    private int $idFornitore;
    private string $ragioneSociale;
    private string $citta;
    private string $email;

    public function __construct(int $idFornitore, string $ragioneSociale, string $citta, string $email) {
        $this->idFornitore = $idFornitore;
        $this->ragioneSociale = $ragioneSociale;
        $this->citta = $citta;
        $this->email = $email;
    }

    // Getter per le proprietà private
    // magic method
    // non ritorna un tipo specifico ma è mixed perché vale per tutte le proprietà
    public function __get($name) {
        // gli passo idFornitore e lui mi ritorna $this->idFornitore 
        //vale per tutte le proprietà
        return $this->$name;
    }

    public function __set($name, $value) {
        // gli passo idFornitore e lui mi setta $this->idFornitore = $value
        // vale per tutte le proprietà
        $this->$name = $value;
    }

    public function __tostring() {
        return "Fornitore: " . $this->ragioneSociale . " - Città: " . $this->citta . " - Email: " . $this->email;
    }
}
