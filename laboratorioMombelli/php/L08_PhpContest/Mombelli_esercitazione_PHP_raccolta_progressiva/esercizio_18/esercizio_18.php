<?php

//Esercizio 18 – Province e sigle

//LIVELLO 8 – Array Associativi
//Esercizio 18 – Province e sigle
//Obiettivo
//Creare un array associativo contenente:
//
//Provincia
//Sigla
//
//Quindi mostrare una tendina (select) html con nome della provincia e sigla come value,
//inviare il form e verificare il corretto funzionamento


?>

<!doctype html>
<html lang="en">
<head>
    <!-- Document head start: metadata, title, and linked resources -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="01-print-reverse">
    <meta name="author" content="Maikol">
    <title>Esercizio 18</title>

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
    <?php 
        $province = [
            ["sigla" => "TO", "nome" => "Torino"],
            ["sigla" => "MI", "nome" => "Milano"],
            ["sigla" => "RM", "nome" => "Roma"],
            ["sigla" => "NA", "nome" => "Napoli"],
            ["sigla" => "FI", "nome" => "Firenze"]
        ];
    ?>
    <!-- Main visible content of the page -->
    <h1>Esercizio 18</h1>
    <form action="" method="POST">
        <select name="provincia" id="">
            <?php foreach ($province as $provincia): ?>
                <option value="<?= $provincia['sigla'] ?>"><?= $provincia['nome'] ?></option>
            <?php endforeach; ?>
        </select>
        <input type="submit" value="Invia">
    </form>


    <article>
        <h1>Provincia Selezionata <?php echo $_POST['provincia'] ?? 'Nessuna provincia selezionata'; ?></h1>
    </article>
</body>
</html>