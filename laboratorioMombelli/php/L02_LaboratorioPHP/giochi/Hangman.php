<?php



class HangMan {
    public string $player1;
    public string $player2;


    public function gioca(string $parola): string {
        // logica del gioco
        return "Si gioca";
    }

    // single line comment

    /*
     * multi line comment
     * multi line comment
     * multi line comment
     */
}

$impiccato1 = new HangMan();
echo $impiccato1->player1 = "Mario";
echo $impiccato1->player2 = "PC";


echo $impiccato1->gioca("Parametro");
