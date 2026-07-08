<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

Route::get('/user', function (Request $request) {
    return $request->user();
})->middleware('auth:sanctum');

// Transactions JSON REST API (protected by Sanctum)
Route::middleware('auth:sanctum')->prefix('transactions')->group(function () {
    Route::get('/', [\App\Http\Controllers\Api\TransactionController::class, 'index']);
    Route::post('/', [\App\Http\Controllers\Api\TransactionController::class, 'store']);
    Route::get('/{transaction}', [\App\Http\Controllers\Api\TransactionController::class, 'show']);
    Route::put('/{transaction}', [\App\Http\Controllers\Api\TransactionController::class, 'update']);
    Route::patch('/{transaction}', [\App\Http\Controllers\Api\TransactionController::class, 'update']);
    Route::delete('/{transaction}', [\App\Http\Controllers\Api\TransactionController::class, 'destroy']);
});




