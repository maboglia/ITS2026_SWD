<?php
namespace APP\repos;

use APP\model\Automobile;

use PDO;

class AutomobileRepository {

    private $pdo;

    public function __construct() {
        $this->pdo = new PDO('mysql:host=localhost;dbname=autosalone', 'root', 'root'); 
    }
//
   // public function save(Automobile $automobile) {
   //     $stmt = $this->pdo->prepare("INSERT INTO automobili (id, marca, modello, cilindrata, prezzo) VALUES (:id, :marca, :modello, :cilindrata, :prezzo)");
   //     // prepare serve a evitare SQL injection, è una buona pratica sempre usarlo quando si inseriscono dati dinamici in una query
   //     $stmt->execute([
   //         ':id' => $automobile->__get('id'),
   //         ':marca' => $automobile->__get('marca'),
   //         ':modello' => $automobile->__get('modello'),
   //         ':cilindrata' => $automobile->__get('cilindrata'),
   //         ':prezzo' => $automobile->__get('prezzo')
   //     ]);
   // }
//
    // Altri metodi per recuperare, aggiornare o eliminare automobili dal database
    public function findAll(){
        $stmt = $this->pdo->query("SELECT id,Marca,Modello,Cilindrata,Prezzo FROM automobili");

        $stmt->setFetchMode(PDO::FETCH_OBJ);
        $automobili = [];
        while ($auto = $stmt->fetch()) {
            $automobili[] = new Automobile($auto->id, $auto->Marca, $auto->Modello, $auto->Cilindrata, $auto->Prezzo);
        }
        return $automobili;
    }
}