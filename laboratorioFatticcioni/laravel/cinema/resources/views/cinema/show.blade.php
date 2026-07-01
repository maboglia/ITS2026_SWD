@extends('layouts.app')


@section('content')

<article>
    <h1>{{ $cinema->nome_cinema }}</h1>
    <p>Indirizzo: {{ $cinema->indirizzo }}</p>
    <p>Telefono: {{ $cinema->telefono }}</p>
    <p>Posti disponibili: {{ $cinema->posti_disponibili }}</p>
</article>
@endsection