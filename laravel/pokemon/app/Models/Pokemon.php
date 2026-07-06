<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Pokemon extends Model
{
    protected $table = 'pokemon';

    protected function getPokemonImageSlug(): string
    {
        $name = $this->attributes['name'] ?? '';
        $clean = trim(preg_replace('/\s+/', ' ', $name));

        if (stripos($clean, 'Mega') !== false) {
            $slugBase = preg_replace('/\s*Mega\s*/i', ' ', $clean);
            $slugBase = trim(preg_replace('/\s+/', ' ', $slugBase));

            $parts = explode(' ', $slugBase);
            if (count($parts) > 1 && end($parts) === $parts[0]) {
                array_pop($parts);
            }

            return strtolower(implode('-', $parts)) . '-mega';
        }

        return strtolower(str_replace(' ', '-', $clean));
    }

    public function getImageUrlAttribute()
    {
        return "https://img.pokemondb.net/sprites/home/normal/2x/" . $this->getPokemonImageSlug() . ".jpg";
    }

    public function getLargeImageUrlAttribute()
    {
        return "https://img.pokemondb.net/artwork/large/" . $this->getPokemonImageSlug() . ".jpg";
    }
}
