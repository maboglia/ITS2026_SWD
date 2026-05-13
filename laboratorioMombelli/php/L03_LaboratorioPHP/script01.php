<?php
declare(strict_types=1);

function applicaSconto(float $prezzo, int|float $sconto): float {

    if ($sconto < 0 || $sconto > 100) {
        throw new InvalidArgumentException("Sconto non valido: $sconto");
    }

    return $prezzo - ($prezzo * ($sconto / 100));
}

echo applicaSconto(100, 20);