<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class pokemon extends Model
{
    protected $table = 'pokemon';

        private function baseSlug()
    {
        $firstPart = explode(' ', $this->attributes['Name'])[0];
        return strtolower(preg_replace('/Mega$/', '', $firstPart));
    }

    public function getImagineUrlAttribute()
    {
        return "https://img.pokemondb.net/sprites/home/normal/2x/{$this->baseSlug()}.jpg";
    }

    public function getImagineUrlLargeAttribute()
    {
        return "https://img.pokemondb.net/artwork/large/{$this->baseSlug()}.jpg";
    }

    public function getImagineUrlMegaAttribute()
    {
        $name      = $this->attributes['Name'];
        $firstPart = explode(' ', $name)[0]; // "VenusaurMega" or "Pikachu"
        $slug      = $this->baseSlug();

        // Only build a Mega URL if the name is actually a Mega form.
        if (str_ends_with($firstPart, 'Mega')) {
            if (str_ends_with($name, ' X')) {
                $slug .= '-mega-x';        // Charizard / Mewtwo X
            } elseif (str_ends_with($name, ' Y')) {
                $slug .= '-mega-y';        // Charizard / Mewtwo Y
            } else {
                $slug .= '-mega';
            }
        }
        // else: not a Mega -> $slug stays the normal name -> normal artwork

        return "https://img.pokemondb.net/artwork/large/{$slug}.jpg";
    }

    public function getIsMegaAttribute()
    {
        $firstPart = explode(' ', $this->attributes['Name'])[0];
        return str_ends_with($firstPart, 'Mega'); // "VenusaurMega" -> true, "Pikachu" -> false
    }

}    
    ## VenusaurMega Venusaur