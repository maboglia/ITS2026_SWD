<?php

namespace App\Http\Controllers;

use App\Models\FilmInSala;
use Illuminate\Http\Request;

class FilmInSalaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $film_in_salas = FilmInSala::all();
        return view('film_in_sala.index', compact('film_in_salas'));
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
    public function show(FilmInSala $filmInSala)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(FilmInSala $filmInSala)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, FilmInSala $filmInSala)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(FilmInSala $filmInSala)
    {
        //
    }
}
