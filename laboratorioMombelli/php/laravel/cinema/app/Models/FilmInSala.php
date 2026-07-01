<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class FilmInSala extends Model
{
    protected $table = 'film_in_salas';

    public function film()
    {
        return $this->belongsTo(Film::class);
    }

    public function cinema()
    {
        return $this->belongsTo(Cinema::class);
    }
}
