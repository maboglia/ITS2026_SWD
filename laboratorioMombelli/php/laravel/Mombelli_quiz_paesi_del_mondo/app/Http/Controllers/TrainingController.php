<?php

namespace App\Http\Controllers;

use App\Services\GestoreDomande;
use Illuminate\View\View;

class TrainingController extends Controller
{
    public function index(GestoreDomande $gestoreDomande): View
    {
        $paese = $gestoreDomande->trovaPaeseCasuale();

        return view('training.index', [
            'paese' => $paese,
            'bandieraUrl' => $paese?->flag_url,
        ]);
    }
}