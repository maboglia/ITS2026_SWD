<?php

use App\Http\Controllers\TransactionController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;

Route::get('/', function () {
    return view('welcome');
});

// Authentication routes
Route::middleware('guest')->group(function () {
    Route::get('/register', [UserController::class, 'register'])->name('register');
    Route::post('/register', [UserController::class, 'store'])->name('register.store');

    Route::get('/login', [UserController::class, 'login'])->name('login');
    Route::post('/login', [UserController::class, 'authenticate'])->name('login.authenticate');
});

Route::post('/logout', [UserController::class, 'logout'])->name('logout')->middleware('auth');

Route::get('/dashboard', function () { return view('Dashboard.index'); })->name('dashboard')->middleware('auth');

Route::resource('transactions', TransactionController::class);
    