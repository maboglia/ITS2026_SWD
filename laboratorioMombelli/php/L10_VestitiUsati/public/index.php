<?php

require_once __DIR__ . '/../vendor/autoload.php';

use App\Controllers\HomeController; # corrisponde agli import di Java
$controller = new HomeController();
$controller->index();
