<?php 

include_once "../repos/FornitoreRepo.php";

class Magazzino {
    private FornitoreRepo $fornitoreRepo;

    public function __construct() {
        $this->fornitoreRepo = new FornitoreRepo();
    }

    public function getFornitori(): array {
        return $this->fornitoreRepo->__getFornitori();
    }

    public function getFornitoreById(int $id): array {
        return $this->fornitoreRepo->getFornitoreById($id);
    }
}