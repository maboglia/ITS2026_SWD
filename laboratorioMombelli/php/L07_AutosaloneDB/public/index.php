<?php

require_once '../vendor/autoload.php';

use APP\controller\AutomobileCtrl;
//use PDO;
//
//$pdo = new PDO('mysql:host=localhost;dbname=autosalone', 'root', 'root');

$ctrl = new AutomobileCtrl();

//$auto = $ctrl->createAutomobile(1, "Fiat", "Panda", 1200, 8000);
//
//echo "Automobile creata con successo:\n";
//echo $auto;


$pagina = $_GET['p'] ?? 'automobili'; // se non è presente il parametro p, di default mostro la pagina delle automobili

switch ($pagina) {
    case 'automobili':
        $ctrl->getAutomobili();
        break;
    case 'moto':
        $ctrl->getMoto();
        break;
    case 'all':
        $ctrl->getAll();
        break;
    default:
        $ctrl->getAutomobili();
        break;
}