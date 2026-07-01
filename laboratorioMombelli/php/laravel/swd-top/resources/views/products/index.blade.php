<!-- resources/views/pages/home.blade.php -->
@extends('layout.app')

@section('title', $title)

@section('content')
    <h1>Benvenuti nella pagina prodotti</h1>
    <p>Questa è la sezione dei prodotti</p>

    @foreach ($prodotti as $prodotto)

        <article>
            <header>
                <h1>{{ $prodotto->nome }}</h1>
            </header>
            <p>
                <a href="{{ route('categorie', $prodotto->categoria) }}" class="btn">Tutti i prodotti di {{ $prodotto->categoria }}</a>
            </p>
            <a href="{{ route('products.show', $prodotto->id) }}" class="btn">Vedi Prodotto</a>
        </article>
    
    @endforeach
@endsection
