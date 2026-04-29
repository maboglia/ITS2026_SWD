<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?php intesta_pagina(); ?></title>
</head>
<body>

    <?php
        function intesta_pagina() {
            echo "Ciao";
        }
        function addizione($a, $b) {
            return $a + $b;
        }

        echo addizione(5, 10); // Output: 15
//        $frutti = ["mela", "banana", "arancia"]; // array scalare
//        $frutti = array("mela", "banana", "arancia");
//
//        $frutta2 = [
//            "mela" => "rosso",
//            "banana" => "giallo",
//            "arancia" => "arancione"
//        ]; // array associativo
//
//        if (isset($_GET["nome"])) {
//            $nome = $_GET["nome"];
//            echo "<h1>Ciao, $nome!</h1>";
//        } else {
//            echo "<h1>Ciao, ospite!</h1>";
//        }
//    //$a =4;
//    //
//    //    if($a>5){
//    //        echo "Greater than 5";
//    //    }else{
//    //        echo "Less than 5";
//    //    }
//    $smg = "Pitone sei arrivato alla fine!";
//        echo "<h1>Hello World!</h1>";
//        echo "<h2>Pitone sei finito!</h2>";
//        echo "<h3>Adesso il mondo è più bello!</h3>";
//    
//     $titolo = "Siamo arrivati alla fine";
//     for ($i=1; $i <= 6; $i++) { 
//         echo "<h$i>$titolo</h$i>";
//     }
//        if($smg == "pippo"){
//            echo "Pitone sei arrivato alla fine!";
//        } else {
//            echo "Pitone non sei arrivato alla fine!";
//        }
//    
//        while ($smg == "pippo") {
//            echo "Pitone sei arrivato alla fine!";
//            break;
//        }
    ?>

<!--
<?php if ($smg == "pippo"): ?>
        <h3>Pitone sei arrivato alla fine!</h3>
    <?php else: ?>
        <h3>Pitone non sei arrivato alla fine!</h3>
    <?php endif; ?>



<h3><?=$smg?></h3>
 --> 

<h3><?php intesta_pagina(); ?></h3>
</body>
</html>