<?php

use App\Models\Cinema;
use App\Models\Film;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

Route::get('/films', function () {
    $films = Film::all();
    return response($films);
});

Route::get('/cinemas', function () {
    $cinemas = Cinema::all();
    return response($cinemas);
});