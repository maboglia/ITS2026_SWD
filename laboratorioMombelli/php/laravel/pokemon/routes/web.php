<?php

use App\Http\Controllers\PokemonController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::get('pokemon/type/{type?}', [PokemonController::class, 'index'])->name('pokemon.type');
Route::resource('pokemon', PokemonController::class);

