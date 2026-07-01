@extends('layouts.app')
@section('content')
<h1>Film in sala</h1>
    <ul>
        @foreach ($filmInSalas as $filmInSala)
            <li>{{ $filmInSala->film->titolo }} - {{ $filmInSala->cinema->nome_cinema }} </li>
        @endforeach
    </ul>
@endsection