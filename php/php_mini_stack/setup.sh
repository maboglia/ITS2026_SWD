#!/bin/bash

echo "🚀 Avvio configurazione Mini-Stack PHP..."

# 1. Creazione della struttura delle cartelle
echo "📁 Creazione cartelle..."
mkdir -p config public src/Controllers

# 2. Creazione del file composer.json
echo "📝 Generazione composer.json..."
cat << 'EOF' > composer.json
{
    "name": "app/mini-stack",
    "description": "Mini stack PHP con FastRoute",
    "type": "project",
    "require": {
        "nikic/fast-route": "^2.0"
    },
    "autoload": {
        "psr-4": {
            "App\\": "src/"
        }
    }
}
EOF

# 3. Creazione di config/routes.php
echo "📝 Generazione config/routes.php..."
cat << 'EOF' > config/routes.php
<?php

return FastRoute\simpleDispatcher(function(FastRoute\RouteCollector $r) {
    $r->addRoute('GET', '/', 'App\Controllers\ApiController@home');
    $r->addRoute('POST', '/api/dati', 'App\Controllers\ApiController@riceviDati');
});
EOF

# 4. Creazione di src/Controllers/ApiController.php
echo "📝 Generazione src/Controllers/ApiController.php..."
cat << 'EOF' > src/Controllers/ApiController.php
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
EOF

# 5. Creazione di public/index.php
echo "📝 Generazione public/index.php..."
cat << 'EOF' > public/index.php
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
EOF

# 6. Installazione dipendenze Composer
echo "📦 Installazione delle dipendenze con Composer..."
if command -v composer &> /dev/null
then
    composer install
    composer require nikic/fast-route
    composer dump-autoload
else
    echo "⚠️ Errore: Composer non è installato globalmente. Esegui 'composer install' manualmente."
fi

echo "✅ Struttura completata con successo!"
echo "🚀 Avvia il server con: php -S localhost:8000 -t public"
