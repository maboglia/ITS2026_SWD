<h1>About us</h1>

<p>Welcome to our website!</p>


<?php

$contatore = 0;

if (isset($_GET["counter"])) {
    $contatore = $_GET["counter"];
}

function incrementa(){
    global $contatore;
    $contatore++;
}

function decrementa(){
    global $contatore;
    $contatore--;
}

if (isset($_GET['action']) && !empty( $_GET['action'])) {
    $action = $_GET['action'];
    if ($action == 'incrementa'){
        incrementa();
    }elseif ($action == 'decrementa'){
        decrementa();
    }
}

?>
<div>
    <a href="?page=about&&action=incrementa&counter= <?= $contatore ?>" class="btn">Incrementa</a>
    <a href="?page=about&&action=decrementa&counter= <?= $contatore ?>" class="btn">Decrementa</a>
</div>

<?php

    $calciatori = ['Ronaldo','Messi','Neymar','Mbappè','Lewa'];
    $calciatori_img = ['images/ronaldo.jpg','images/messi.jpg','images/neymar.jpg','images/mbapee.jpg','images/lewa.jpg']

?>

<h3>Contatore = <?= $contatore ?></h3>

<h4><?= $calciatori[$contatore % count($calciatori)] ?></h4>


<div>
    <a href="?page=about&&action=incrementa&counter= <?= $contatore ?>" class="btn">
        <img src="<?= $calciatori_img[$contatore % count($calciatori_img)] ?>" alt = "Il calciatore del giorno è: <?= $calciatori[$contatore % count($calciatori)] ?>" >
    </a>
</div>