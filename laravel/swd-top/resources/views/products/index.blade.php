<!-- resources/views/pages/home.blade.php -->
@extends('layouts.app')

@section('title', $title)

@section('content')
    <h1>{{ $title }}</h1>
    <p>Questa è la sezione prodotti della nostra applicazione.</p>

    @foreach ($prodotti as $prodotto)
    
        <article>
            <header>
                <h1>{{ $prodotto->nome }}</h1>
            </header>
            <p>
                <a href="{{ route('categorie', $prodotto->categoria) }}" class="btn">Tutti i prodotti di cat {{ $prodotto->categoria }}</a>
                
            </p>
            <a href="{{ route('products.show', $prodotto->id) }}" class="btn">Vedi prodotto</a>
        </article>

    @endforeach


@endsection