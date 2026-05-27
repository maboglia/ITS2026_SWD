<?php

namespace APP\controller;

use APP\model\Automobile;

use APP\repos\AutomobileRepository;
use APP\repos\MotociclettaRepository;
class AutomobileCtrl {

    private $repo;
    private $repoMoto;
    public function __construct() {
        $this->repo = new AutomobileRepository();
        $this->repoMoto = new MotociclettaRepository();
    }   
    
    

    public function createAutomobile($id, $marca, $modello, $cilindrata, $prezzo) {

        return new Automobile($id, $marca, $modello, $cilindrata, $prezzo);
    }

    public function getAutomobili() {
        $automobili = $this->repo->findAll();
        $titolo = "Automobili";
        include __DIR__ . '/../view/header.php';
        include __DIR__ . '/../view/veicoli.php';
        include __DIR__ . '/../view/footer.php';
    }

    public function getMoto() {
        $automobili = $this->repoMoto->findAll();
        $titolo = "Motociclette";
        include __DIR__ . '/../view/header.php';
        include __DIR__ . '/../view/veicoli.php';
        include __DIR__ . '/../view/footer.php';
    }
    public function getAll() {
        $automobili = array_merge($this->repo->findAll(), $this->repoMoto->findAll());
        $titolo = "Tutti i veicoli";
        include __DIR__ . '/../view/header.php';
        include __DIR__ . '/../view/veicoli.php';
        include __DIR__ . '/../view/footer.php';
    }

}