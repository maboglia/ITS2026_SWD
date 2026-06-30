<!-- resources/views/pages/home.blade.php -->
@extends('layout.app')

@section('title', $title)

@section('content')
    <h1>Benvenuti nella pagina prodotti</h1>
    <p>Questa è la sezione dei prodotti</p>


        <article>
            <header>
                <h1>{{ $prodotto->nome }}</h1>
            </header>
            <p>{{ $prodotto->categoria }}</p>
            <p>{{ $prodotto->prezzo }}</p>
            <p>{{ $prodotto->giacenza }}</p>
            <a href="{{ route('products.index') }}" class="btn">Torna indietro</a>
        </article>
    

@endsection
