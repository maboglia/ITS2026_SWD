<?php

require __DIR__ . '/../vendor/autoload.php';

$dispatcher = require __DIR__ . '/../config/routes.php';

$httpMethod = $_SERVER['REQUEST_METHOD'];
$uri = $_SERVER['REQUEST_URI'];

if (false !== $pos = strpos($uri, '?')) {
    $uri = substr($uri, 0, $pos);
}
$uri = rawurldecode($uri);

$routeInfo = $dispatcher->dispatch($httpMethod, $uri);

switch ($routeInfo[0]) {
    case FastRoute\Dispatcher::NOT_FOUND:
        http_response_code(404);
        header('Content-Type: application/json');
        echo json_encode(['error' => 'Risorsa non trovata']);
        break;
        
    case FastRoute\Dispatcher::METHOD_NOT_ALLOWED:
        http_response_code(405);
        header('Content-Type: application/json');
        echo json_encode(['error' => 'Metodo non consentito']);
        break;
        
    case FastRoute\Dispatcher::FOUND:
        $handler = $routeInfo[1];
        $vars = $routeInfo[2];
        
        list($class, $method) = explode('@', $handler);
        
        if (class_exists($class) && method_exists($class, $method)) {
            $controller = new $class();
            call_user_func_array([$controller, $method], $vars);
        } else {
            http_response_code(500);
            header('Content-Type: application/json');
            echo json_encode(['error' => 'Controller o metodo non configurato correttamente']);
        }
        break;
}
