<?php


include_once "Categoria.php";
include_once "Fornitore.php";

class Prodotto {
    private int $idProdotto;
    private string $nome;

    private float $prezzoUnitario;

    private int $quantitaStock;

    private Categoria $categoria;


    private Fornitore $fornitore;

    public function __construct(int $idProdotto, string $nome, float $prezzoUnitario, int $quantitaStock, Categoria $categoria, Fornitore $fornitore) {
        $this->idProdotto = $idProdotto;
        $this->nome = $nome;
        $this->prezzoUnitario = $prezzoUnitario;
        $this->quantitaStock = $quantitaStock;
        $this->categoria = $categoria;
        $this->fornitore = $fornitore;
    }

    public function __get($name) {
        return $this->$name;
    }

    public function __set($name, $value) {
        $this->$name = $value;
    }

    public function __tostring() {
        return "Prodotto: " . $this->nome . " - Prezzo Unitario: " . $this->prezzoUnitario . " - Quantità in Stock: " . $this->quantitaStock . "\n" .
               "Categoria: " . $this->categoria->nome . "\n" .
               "Fornitore: " . $this->fornitore->ragioneSociale;
    }
}