<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Prenotazioni extends Model
{
    protected $table = 'prenotazionis';
    
    public function filmInSala()
    {
        return $this->belongsTo(FilmInSala::class);
    }
}
