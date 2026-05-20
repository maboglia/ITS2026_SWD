<?php

include_once "../model/Prodotto.php";
include_once "../repos/FornitoreRepo.php";
include_once "../presentation/MagazzinoREST.php";

//$p = new Prodotto(1, "Laptop", 999.99, 10, new Categoria(1, "Elettronica", "Dispositivi elettronici"), new Fornitore(1, "TechSupplier", "Milano", "info@techsupplier.it"));

// ispettore
//var_dump($p);

// stampa leggibile
//print_r($p);


//\$fornitoreDao = new FornitoreRepo();
//\
//\print_r($fornitoreDao->__getFornitori());

//$rest = new MagazzinoREST();
//
//echo $rest->getFornitori();

header ('Content-Type: application/json');

if ($_SERVER['REQUEST_METHOD'] === 'GET'){
    if (isset($_GET['idFornitore'])){
        $idFornitore = intval($_GET['idFornitore']);
        echo (new MagazzinoREST())->getFornitoreById($idFornitore);
    } else {
        echo (new MagazzinoREST())->getFornitori();
    }
} else {
    http_response_code(405); // Method Not Allowed
    echo json_encode(['error' => 'Metodo non supportato']);
}
