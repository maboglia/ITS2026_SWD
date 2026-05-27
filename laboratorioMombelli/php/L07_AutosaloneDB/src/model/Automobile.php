<?php

namespace APP\model;

class Automobile
{


    public function __construct(private $id, private $marca , private $modello, private $cilindrata , private $prezzo ){}

    public function __get($name){
        return $this->$name;
    }

    public function __set($name, $value){
        $this->$name = $value;
    }

    public function __toString(){
        return "Automobile: id=$this->id, marca=$this->marca, modello=$this->modello, cilindrata=$this->cilindrata, prezzo=$this->prezzo";
    }
}