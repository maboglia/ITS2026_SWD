<?php

include_once '../model/Fornitore.php';

class FornitoreRepo{
    private array $fornitori = [];

    public function __construct(){
        $this->fornitori = $this->caricaFornitori();
    }

    private function caricaFornitori(): array | null{ // restituisce un array di Fornitore o null se non riesce a caricare i dati
        $fornitori = file_get_contents('../database/fornitori.json');
        return json_decode($fornitori, true); // true o false per decidere se restituire un array associativo (chiave valore) o un array scalare

    }

    public function aggiungiFornitore(Fornitore $fornitore): void{
        $this->fornitori[] = $fornitore; // aggiungo un fornitore all'array dei fornitori
    }

    public function __getFornitori(): array{
        return $this->fornitori; // restituisce l'array dei fornitori
    }

    public function getFornitoreById(int $idFornitore): ?array {
        foreach ($this->fornitori as $fornitore) {
            if ($fornitore['id_fornitore'] === $idFornitore) {
                return $fornitore;
            }
        }

        return null; // Ritorna null se non trovato
    }

       public function updateFornitore(Fornitore $fornitore) {
        foreach ($this->fornitori as $index => $f) {
            if ($f->idFornitore === $fornitore->idFornitore) {
                $this->fornitori[$index] = $fornitore;
                return true; // Aggiornamento riuscito
            }
        }
        return false; // Fornitore non trovato
    }

  public function deleteFornitore(int $idFornitore) {
        foreach ($this->fornitori as $index => $fornitore) {
            if ($fornitore->idFornitore === $idFornitore) {
                array_splice($this->fornitori, $index, 1);
                return true; // Cancellazione riuscita
            }
        }
        return false; // Fornitore non trovato
    }

}