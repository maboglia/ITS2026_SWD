 
 <?php

$pagina = 'home';

if (isset($_GET['page']) && !empty($_GET['page'])){
    $pagina = $_GET['page'];
}

switch ($pagina) {
    case 'home':
        include 'home.php';
        break;
    case 'about':
        include 'about.php';
        break;
    case 'services':
        include 'services.php';
        break;
    case 'contact':
        include 'contact.php';
        break;
    default:
        $saluto = 'Pagina non trovata';
        echo "La pagina richiesta non esiste.";
        break;
}

//$saluti = ['hola', 'ciao', 'hello', 'hi', 'hallo', 'salve'];

//$saluto = $saluti[array_rand($saluti)];

?>
 

