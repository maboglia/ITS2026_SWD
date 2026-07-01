<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/films', function () {
    $films = App\Models\Film::all();
    return response()->json($films);
});

Route::get('/cinema', function () {
    $cinemas = App\Models\Cinema::all();
    return response()->json($cinemas);
});

Route::get('/film_in_sala', function () {
    $filmInSalas = App\Models\FilmInSala::all();
    return response()->json($filmInSalas);
});

Route::get('/prenotazioni', function () {
    $prenotazionis = App\Models\Prenotazioni::all();
    return response()->json($prenotazionis);
});
