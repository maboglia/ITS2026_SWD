<?php

namespace App\Http\Controllers;

use App\Models\pokemon;
use Illuminate\Http\Request;

class PokemonController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(?string $type = null)
    {
        $types = pokemon::query()
            ->whereNotNull('Type 1')
            ->where('Type 1', '!=', '')
            ->distinct()
            ->orderBy('Type 1')
            ->pluck('Type 1');

        $pokemonQuery = pokemon::query();

        if ($type !== null && $type !== '') {
            $pokemonQuery->where('Type 1', $type);
        }

        $pokemon = $pokemonQuery->orderBy('id')->get();

        return view('pokemon.index', compact('pokemon', 'types', 'type'));
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
    public function show(pokemon $pokemon)
    {
        return view('pokemon.show', compact('pokemon'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(pokemon $pokemon)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, pokemon $pokemon)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(pokemon $pokemon)
    {
        //
    }
}
