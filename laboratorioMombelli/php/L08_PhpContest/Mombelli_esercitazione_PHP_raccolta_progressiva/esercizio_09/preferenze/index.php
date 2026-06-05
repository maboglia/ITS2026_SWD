<?php
session_start();

//if (!isset($_SESSION['series'])){
//    $_SESSION['series'] = [];
//}

$series = $_SESSION['series'] ?? [];

if (isset($_POST['emptyList'])){
    $_SESSION['series'] = [];
}



if ($_SERVER['REQUEST_METHOD'] == 'POST'){
    $titolo = $_POST['titolo'] ?? null;

    if ($titolo){
        $series[] = $titolo;
        $_SESSION['series'] = $series;
    }
}



?>




<!doctype html>
<html lang="en">
<head>
    <!-- Document head start: metadata, title, and linked resources -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="01-print-reverse">
    <meta name="author" content="Maikol">
    <title>Serie TV</title>

    <!-- Open Graph metadata used by social platforms when the page is shared -->
    <!--
    <meta property="og:title" content="Title">
    <meta property="og:type" content="Type">
    <meta property="og:url" content="URL">
    <meta property="og:description" content="Description of the content">
    <meta property="og:image" content="Image">
    -->
    <!--
    <link rel="icon" href="favicon.ico">
    -->
    <!-- Favicon displayed in the browser tab -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
    <!-- Link to external CSS stylesheet for page styling -->
</head>
<body>
    <!-- Main visible content of the page -->
    <div class="container">
        <form action="" method="POST">

            <input type="text" name="titolo" id= "titolo" placeholder="Titolo Serie">
            <input type="submit" value="Add Serie">

        </form>
        <form method="POST">
            <input type="submit" value="Empty List">
            <input type="hidden" name="emptyList">
        </form>

        
        <div style="display: flex;">
            <div>
                <h1>Lista Serie</h1>
                
                <?php foreach ($series as $serie): ?>
                    <h3><?=$serie?></h3>
                    <button onclick="showInfo('<?=$serie?>')">Vedi Dettagli</button>
                    
                <?php endforeach; ?>
                    
            </div>
            <div style ="margin-left: 100px;">
            
                <h1>Dettagli Serie</h1>
                <h2 id="genere"></h2>
                <h2 id="rating"></h2>
                <h2 id="status"></h2>
                <img src="" alt="immagine">
            </div>
        </div>
    </div>
<script>
function showInfo(titolo){
    const url = 'https://api.tvmaze.com/singlesearch/shows?q=' + titolo;
    
    fetch(url)
        .then(response => response.json())
        .then(serie => {
            document.getElementById("genere").textContent = serie.genres.join(" ");
            document.getElementById("rating").textContent = serie.rating.average;
            document.getElementById("status").textContent = serie.status;
            document.querySelector("img").src = serie.image.medium;
        })
}
</script>
            
</body>
</html>