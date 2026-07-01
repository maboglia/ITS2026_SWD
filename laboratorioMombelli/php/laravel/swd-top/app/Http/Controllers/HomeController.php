<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class HomeController extends Controller
{
    public function index($nome = null)
    {
        return view('swd', ['nome' => $nome]);
    }
}
