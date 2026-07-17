<?php

namespace App\Http\Controllers;

use App\Models\QuizSession;
use Illuminate\View\View;

class HomeController extends Controller
{
    public function index(): View
    {
        return view('index', [
            'quizSessions' => QuizSession::query()
                ->latest()
                ->limit(5)
                ->get(),
        ]);
    }
}