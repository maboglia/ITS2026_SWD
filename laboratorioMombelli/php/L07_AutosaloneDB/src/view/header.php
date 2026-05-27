<!doctype html>
<html lang="en">
<head>
    <!-- Document head start: metadata, title, and linked resources -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="01-print-reverse">
    <meta name="author" content="Maikol">
    <title><?= $titolo ?></title>

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

    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"> <!-- Bootstrap CSS for styling -->
    
    <!-- Link to external CSS stylesheet for page styling -->

    <!-- <script defer src="./scripts/main.js"></script> --> <!-- Defer loading of main JavaScript until after HTML parsing -->
    <!-- End of the head section -->
</head>
<body>
    <!-- Main visible content of the page -->
     <div class="container">
        <nav>
            <ul>
                <li><strong>Autosalone SWD_TOP</strong></li>
            </ul>
            <ul>
                <li><a href="?p=auto" class="contrast"> Automobili</a></li>
                <li><a href="?p=moto" class="contrast"> Motociclette</a></li>
                <li><a href="?p=all" class="contrast"> Tutti i veicoli</a></li>
            </ul>
        </nav>