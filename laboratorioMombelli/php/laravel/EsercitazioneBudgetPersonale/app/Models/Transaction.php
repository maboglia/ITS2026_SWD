<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Transaction extends Model
{
    protected $table = 'transactions';
    // Allow mass assignment for these fields
    protected $fillable = [
        'user_id',
        'description',
        'date',
        'amount',
        'category',
        'receipt',
    ];
    protected $casts = [
    'date' => 'datetime',
];
}
