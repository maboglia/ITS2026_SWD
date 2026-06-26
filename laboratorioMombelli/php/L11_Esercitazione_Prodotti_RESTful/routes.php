<?php

require "./controllers/ProdottoController.php";

$requestMethod = $_SERVER['REQUEST_METHOD'];

// Path of the URL only, without query string
$requestPath = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);

// Folder the API is installed in, e.g. /MyNotes/PHP/api
$basePath = rtrim(dirname($_SERVER['SCRIPT_NAME']), '/');

// Strip the base folder so routing works no matter how deep the app is installed
$route = trim(substr($requestPath, strlen($basePath)), '/');

$parts = $route === '' ? [] : explode('/', $route);

$resource = $parts[0] ?? "";
$id = $parts[1] ?? null;

switch ($requestMethod) {

    case "GET":
        $id ? getProdotti($id) : getProdotti();
        break;

    case "POST":
        $data = json_decode(file_get_contents('php://input'), true);
        createProdotto($data);
        break;

    case "PUT":
        $data = json_decode(file_get_contents('php://input'), true);
        updateProdotto($id, $data);
        break;

    default:
        http_response_code(405);
        echo json_encode(["error" => "Method not allowed"]);
        break;

}