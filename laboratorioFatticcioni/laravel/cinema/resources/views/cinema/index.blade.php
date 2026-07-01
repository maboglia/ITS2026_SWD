@extends('layouts.app')

@section('content')
    <h1>Sale Cinematografiche</h1>
    <ul>
        @foreach ($cinemas as $cinema)
            <li><a href="{{ route('cinema.show', $cinema->id) }}">{{ $cinema->nome_cinema }}</a></li>
        @endforeach
    </ul>
@endsection