<?php

namespace App\Repos;

use App\Models\Tshirt;
use App\Repos\AbbigliamentoDAO;

class AbbigliamentoDAOImpl implements AbbigliamentoDAO
{
    public function getAllMagliette(): array
    {


        $abbigliamentoJson = './data/abbigliamento.json';
        $abbigliamento = json_decode(file_get_contents($abbigliamentoJson), true);
        
        $magliette = [];
        foreach ($abbigliamento as $maglietta) {
            $magliette[] = new Tshirt(1, $maglietta['nome'], $maglietta['prezzo'], $maglietta['categoria']);
        }


        return $magliette;


        #return [
        #    new Tshirt(1, 'T-shirt Bianca', 19.99, 'Una maglietta bianca in cotone'),
        #    new Tshirt(2, 'T-shirt Nera', 24.99, 'Una maglietta nera in cotone'),
        #    new Tshirt(3, 'T-shirt Rossa', 29.99, 'Una maglietta rossa in cotone'),
        #];
    }
}