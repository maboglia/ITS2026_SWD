@extends('layouts.app')
@section('content')

<h1>La Lista dei Nostri Film</h1>

<ul>
    @foreach ($films as $film)
        <li><a href="{{ route('film.show', $film) }}">{{ $film->titolo }}</a></li>
    @endforeach
</ul>

@endsection