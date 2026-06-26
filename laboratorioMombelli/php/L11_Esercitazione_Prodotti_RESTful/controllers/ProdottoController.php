<?php

require "./database/database.php";

function getProdotti($id = null) {
    global $pdo;

    if ($id) {

        $query = "SELECT * FROM prodotti WHERE id = ?";
        $statement = $pdo->prepare($query);
        $statement->execute([$id]);
    } else {
        $query = "SELECT * FROM prodotti";
        $statement = $pdo->prepare($query);
        $statement->execute();
    }

    echo json_encode($statement->fetchAll());
}

function createProdotto($data) {
    global $pdo;

    if ($data === []) {
        throw new Exception("Data array cannot be empty");
    }

    $query = "INSERT INTO prodotti (nome, categoria, prezzo, giacenza) VALUES (?, ?, ?, ?)";
    $statement = $pdo->prepare($query);
    $statement->execute([$data['nome'], $data['categoria'], $data['prezzo'], $data['giacenza']]);

    echo json_encode(['id' => $pdo->lastInsertId()]);
}

function updateProdotto($id, $data) {
    global $pdo;

    if ($data === []) {
        throw new Exception("Data array cannot be empty");
    }

    if ($id === null) {
        throw new Exception("ID cannot be null");
    }

    $checkExistanceQuery = "SELECT COUNT(*) FROM prodotti WHERE id = ?";
    $checkExistanceStatement = $pdo->prepare($checkExistanceQuery);
    $checkExistanceStatement->execute([$id]);
    if ($checkExistanceStatement->fetchColumn() === 0) {
        throw new Exception("Product not found");
    }

    $query = "UPDATE prodotti SET nome = ?, categoria = ?, prezzo = ?, giacenza = ? WHERE id = ?";
    $statement = $pdo->prepare($query);
    $statement->execute([$data['nome'], $data['categoria'], $data['prezzo'], $data['giacenza'], $id]);

    echo json_encode(['rows_affected' => $statement->rowCount()]);

}