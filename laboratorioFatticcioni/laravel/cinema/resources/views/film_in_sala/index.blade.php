@extends('layouts.app')

@section('content')
    <h1>Index Film in Sala</h1>
    <ul>
        @foreach ($film_in_salas as $film_in_sala)
            <li>{{ $film_in_sala->film->titolo }} - {{ $film_in_sala->cinema->nome_cinema }}</li>
        @endforeach
    </ul>
@endsection