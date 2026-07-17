<?php

use App\Http\Controllers\HomeController;
use App\Http\Controllers\QuizController;
use App\Http\Controllers\TrainingController;

Route::get('/', [HomeController::class, 'index'])->name('home');

Route::get('/quiz', [QuizController::class, 'mostraQuiz'])
    ->name('quiz');

Route::post('/quiz/sessions', [QuizController::class, 'nuovaSessione'])
    ->name('quiz.sessions.store');

Route::post('/quiz', [QuizController::class, 'verificaRisposta'])
    ->name('quiz.answer');

Route::post('/quiz/reset', [QuizController::class, 'reset'])
    ->name('quiz.reset');

Route::get('/allenamento', [TrainingController::class, 'index'])
    ->name('training');
