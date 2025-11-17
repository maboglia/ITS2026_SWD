<?php

    $prodotti = file('prodotti.csv');

    $frutta = [];

    foreach ($prodotti as $riga) {

        $riga = str_replace("\"", "", $riga);
        $pezzi = explode(",", $riga);
        $nome = $pezzi[0];
        $prezzo = $pezzi[2];

        $frutta[] = [$nome , $prezzo];
    }

    /*

    $frutta = [
        // 0       1
        ['mele', 2.10]  ,//0
        ['pere', 2.70],//1
        ['fragole', 3.5],//2
    ];
*/
    $quanti = count($frutta);
    $totale = 0;

    $output = '<html>';
    $output .=  "\n";

    $output .= '<head>';
    $output .=  "\n";       
    $output .= '<title>';
    $output .= 'reparto frutta';
    $output .= '</title>';
    $output .=  "\n";   
    $output .= '</head>';
    $output .=  "\n";   
    $output .= '<body>';
    $output .=  "\n";   
    $output .= '<h1>Frutta</h1>';
    
    
    $output .=  "\n";    
    $output .= '<table>';

    for ($i=0; $i < $quanti; $i++) { 

        $output .=  "\n";
        $output .=  "\t";
        $output .= '<tr>';

        for ($j = 0; $j < count($frutta[$j]); $j++){
            $output .=  "\n";
            $output .=  "\t";
            $output .=  "\t";
            $output .= '<td>';

            $output .= $frutta[$i][$j];
            //echo "\t";
            if ($j == 1){
                //echo $frutta[$i][$j];
                //incremento la variabile totale leggendo il prezzo della frutta
                //$totale += $frutta[$i][$j];
            }

            $output .= '</td>';
            
        }
        $output .=  "\n";
        $output .=  "\t";
        $output .= '</tr>';

        $output .=  "\n";
    }
    $output .=  "\n";
    $output .= '</table>';
    $output .=  "\n";

    $output .= "<h2>Il totale dello scontrino è: " . $totale . "</h2>";

    $output .=  "\n";   
    $output .= '</body>';
    $output .=  "\n";   

    $output .=  "\n";
    $output .= "</html>";

    echo $output;


    // for($i = 1; $i <= 10; $i++){
    //     //stampo le righe
    //     for($j = 1; $j <= 10; $j++){
    //         //stampo le colonne
    //         $prodotto = $i * $j;
    //         echo $prodotto;
    //         echo "\t";

    //     }
        
    //     echo "\n";



    // }




?>