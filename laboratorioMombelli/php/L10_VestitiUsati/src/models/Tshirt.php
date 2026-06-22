<?php

namespace App\Models;

use App\Models\Maglia;

class Tshirt extends Maglia
{
    public function __construct($id, $nome, $prezzo, $descrizione)
    {
        parent::__construct($id, $nome, $prezzo, $descrizione);
     
    }


}