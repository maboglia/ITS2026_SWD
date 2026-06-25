<?php

namespace App\Models;
class Maglia
{

    public function __construct(private $id, private $nome, private $prezzo, private $descrizione)
    {
    
    }
    public function __get($name)
    {
        return $this->$name;
    }

    public function __set($name, $value)
    {
        $this->$name = $value;
    }

    public function __toString()
    {
        return "Maglia: $this->nome, Prezzo: $this->prezzo, Descrizione: $this->descrizione";
    }
    
}