<?php

$ip = $_POST["ip"] ?? null;

$url = "http://localhost:8080/api/add?ip=$ip";

header("Location: $url");
exit;
