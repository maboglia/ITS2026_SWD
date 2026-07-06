<?php

use App\Http\Controllers\PokemonController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/pokemon/type', [PokemonController::class, 'type'])->name('pokemon.type');
Route::resource('pokemon', PokemonController::class);