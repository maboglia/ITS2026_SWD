<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class QuizSession extends Model
{
    protected $fillable = [
        'token',
        'difficulty',
        'punteggio',
        'numero_domanda',
        'risposte_date',
        'completata_at',
    ];

    protected $casts = [
        'risposte_date' => 'array',
        'completata_at' => 'datetime',
    ];

    public function isCompletata(): bool
    {
        return $this->completata_at !== null;
    }
}