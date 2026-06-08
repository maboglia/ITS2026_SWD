<?php 

$url = isset($_GET['sezione']) ? "http://localhost:9001/api/prodotti/sezione/" .str_replace(' ','%20',$_GET['sezione']) : "http://localhost:9001/api/prodotti";

$sezioni = "http://localhost:9001/api/prodotti/sezioni";
$response = file_get_contents($url);
$listino = json_decode($response, true);
$sezioni = json_decode(file_get_contents($sezioni), true);
?>

<!doctype html>
<html lang="en">
<head>
    <!-- Document head start: metadata, title, and linked resources -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="01-print-reverse">
    <meta name="author" content="Maikol">
    <title>Title</title>

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

    <script defer src="./scripts/main.js"></script> <!-- Defer loading of main JavaScript until after HTML parsing -->
    <!-- End of the head section -->
</head>
<body>
    <!-- Main visible content of the page -->
    <div class="container">
        <h1>Listino Prezzi Bar</h1>

        <form method="get">
            <label for="sezione">Sezione:</label>
            <select name="sezione" id="sezione">
                <option value="">Tutte</option>
                <?php 
                    foreach($sezioni as $sezione): ?>
                    <option value="<?= $sezione ?>"><?= $sezione ?></option>
                <?php endforeach; ?>
            </select>

            <button type="submit">Filtra</button>
        </form>



        <table>
            <tr>
                <th>Prodotto</th>
                <th>Categoria</th>
                <th>Prezzo</th>
            </tr>
            <?php foreach($listino as $prodotto): ?>
                <tr>
                    <td><?= $prodotto['prodotto'] ?></td>
                    <td><?= $prodotto['sezione'] ?></td>
                    <td><?= $prodotto['prezzo'] ?></td>
                </tr>
            <?php endforeach; ?>
            <tr>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>
    </div>
</body>
</html>