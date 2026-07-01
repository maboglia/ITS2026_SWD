<!-- resources/views/pages/home.blade.php -->
@extends('layouts.app')

@section('title', $title)

@section('content')
    <h1>Benvenuti nella pagina prodotti</h1>
    <p>Questa è la sezione prodotti della nostra applicazione.</p>


    
        <article>
            <header>
                <h1>{{ $prodotto->nome }}</h1>
            </header>
            <p>
                {{ $prodotto->categoria }}
            </p>
            <p>
                {{ $prodotto->prezzo }}
            </p>
            <p>
                {{ $prodotto->giacenza }}
            </p>
            <a href="{{ route('products.index') }}" class="btn">Torna all'elenco</a>
        </article>




@endsection