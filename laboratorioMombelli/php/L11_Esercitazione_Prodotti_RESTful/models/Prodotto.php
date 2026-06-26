<?php

class Prodotto {

    private $id;
    private $nome;
    private $categoria;
    private $prezzo;
    private $giacenza;

    public function __construct($id, $nome, $categoria, $prezzo, $giacenza) {
        $this->id = $id;
        $this->nome = $nome;
        $this->categoria = $categoria;
        $this->prezzo = $prezzo;
        $this->giacenza = $giacenza;
    }

    public function __get($name)
    {
        return $this->$name;        
    }

    public function __set($name, $value)
    {
        $this->$name = $value;
    }
    
}