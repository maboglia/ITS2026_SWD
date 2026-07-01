<?php

namespace App\Http\Controllers;

use App\Models\Product;
use Illuminate\Http\Request;

class ProductController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {

        $title = 'I nostri prodotti';

        $prodotti = Product::all();

        return view('products.index', compact('prodotti', 'title'));
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
    public function show(Product $product)
    {

        $title = 'Scheda prodotto';
        $prodotto = Product::find($product->id);
        return view('products.show', compact('prodotto', 'title'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Product $product)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Product $product)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Product $product)
    {
        //
    }

    public function categorie(string $categoria){
        $prodotti = Product::where('categoria', $categoria)->get();
        $title = 'I prodotti della catregoria: ' . $categoria;

    

        return view('products.index', compact('prodotti', 'title'));
        
    }
}
