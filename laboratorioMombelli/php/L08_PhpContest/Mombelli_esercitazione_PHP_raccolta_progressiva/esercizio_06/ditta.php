<?php

class Ditta {
    function __construct(
        private $Nome,
        private $Ragionesociale,
        private $Indirizzo,
        private $Partitaiva
    ) {}

    public function __toString() {
        return "Nome: " . $this->Nome . "<br>" .
               "Ragione Sociale: " . $this->Ragionesociale . "<br>" .
               "Indirizzo: " . $this->Indirizzo . "<br>" .
               "Partita IVA: " . $this->Partitaiva;
    }

    public function getNome() {
        return $this->Nome;
    }

    public function getRagionesociale() {
        return $this->Ragionesociale;
    }

    public function getIndirizzo() {
        return $this->Indirizzo;
    }

    public function getPartitaiva() {
        return $this->Partitaiva;
    }
}

if (isset($_POST['Nome']) && isset($_POST['Ragionesociale']) && isset($_POST['Indirizzo']) && isset($_POST['Partitaiva'])) {
    
    if (!empty($_POST['Nome']) && !empty($_POST['Ragionesociale']) && !empty($_POST['Indirizzo']) && !empty($_POST['Partitaiva'])) {
        $ditta = new Ditta($_POST['Nome'], $_POST['Ragionesociale'], $_POST['Indirizzo'], $_POST['Partitaiva']);
    } else {
        echo "Compila tutti i campi del form.";
        
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
    <title>Form PHP</title>

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
</head>
<body>
    <!-- Main visible content of the page -->
    <h1>Form PHP</h1>

    <div class="container">
        <article>
            <?=$ditta ?? "Nessuna ditta inserita."?>
        </article>
    </div>
</body>
</html>

