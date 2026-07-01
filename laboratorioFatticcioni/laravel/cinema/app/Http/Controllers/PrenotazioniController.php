<?php

namespace App\Http\Controllers;

use App\Models\Prenotazioni;
use Illuminate\Http\Request;

class PrenotazioniController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $prenotazionis = Prenotazioni::all();
        return view('prenotazioni.index', compact('prenotazionis'));
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(Prenotazioni $prenotazioni)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Prenotazioni $prenotazioni)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Prenotazioni $prenotazioni)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Prenotazioni $prenotazioni)
    {
        //
    }
}
