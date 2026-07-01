<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Prenotazioni extends Model
{
    protected $table = 'prenotazionis';

    protected $fillable = [
        'film_in_sala_id',
        'utente_id',
        'posti_prenotati',
    ];

    public function filmInSala()
    {
        return $this->belongsTo(FilmInSala::class);
    }

}
