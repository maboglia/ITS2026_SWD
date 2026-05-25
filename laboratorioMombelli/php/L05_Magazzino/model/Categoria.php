<?php

class Categoria{
    private int $idCategoria;
    private string $nome;

    private string $descrizione;

    public function __construct(int $idCategoria, string $nome, string $descrizione) {
        $this->idCategoria = $idCategoria;
        $this->nome = $nome;
        $this->descrizione = $descrizione;
    }

    public function __get($name) {
        return $this->$name;
    }

    public function __set($name, $value) {
        $this->$name = $value;
    }

     public function __tostring() {
        return "Categoria: " . $this->nome . " - Descrizione: " . $this->descrizione;
    }
}