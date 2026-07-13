<?php

namespace App\Controllers;

class ApiController 
{
    public function home(): void 
    {
        header('Content-Type: application/json');
        echo json_encode(['message' => 'Benvenuto nella tua Mini-Stack strutturata!']);
    }

    public function riceviDati(): void 
    {
        header('Content-Type: application/json');

        $input = file_get_contents('php://input');
        $data = json_decode($input, true);

        if ($data === null) {
            http_response_code(400);
            echo json_encode(['error' => 'Payload JSON non valido']);
            return;
        }

        echo json_encode([
            'status' => 'success',
            'dati_ricevuti' => $data
        ]);
    }
}
