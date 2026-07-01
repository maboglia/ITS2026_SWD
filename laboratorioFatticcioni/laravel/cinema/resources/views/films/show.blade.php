@extends('layouts.app')


@section('content')

<article>
    <h1>{{ $film->titolo }}</h1>
    <p>Regista: {{ $film->regista }}</p>
    <p>Genere: {{ $film->genere }}</p> 
</article>
@endsection