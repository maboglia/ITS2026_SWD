<?php

return FastRoute\simpleDispatcher(function(FastRoute\RouteCollector $r) {
    $r->addRoute('GET', '/', 'App\Controllers\ApiController@home');
    $r->addRoute('POST', '/api/dati', 'App\Controllers\ApiController@riceviDati');
});
