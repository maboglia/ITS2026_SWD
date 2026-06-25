<?php

namespace App\Controllers; # più o meno corrisponde al package name di una classe Java

use App\Repos\AbbigliamentoDAOImpl;

class HomeController
{
    public function index()
    {
        #return view('home');
        $title = 'Home';
        $abbigliamentoDAO = new AbbigliamentoDAOImpl();
        $magliette = $abbigliamentoDAO->getAllMagliette();

        include_once __DIR__ . '/../views/main/header.php';
        include_once __DIR__ . '/../views/main/menu.php';
        include_once __DIR__ . '/../views/magliette/index.php';
        include_once __DIR__ . '/../views/main/footer.php';
        
    }
}
