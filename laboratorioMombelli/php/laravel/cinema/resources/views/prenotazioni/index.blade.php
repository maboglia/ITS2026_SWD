@extends('layouts.app')
@section('content')
<h1>Lista delle Prenotazioni</h1>
    <ul>
        @foreach ($prenotazionis as $prenotazioni)
            <li>{{ $prenotazioni->nome }} - {{ $prenotazioni->posti_prenotati }} posti prenotati per il film "{{ $prenotazioni->filmInSala->film->titolo }}" al cinema "{{ $prenotazioni->filmInSala->cinema->nome_cinema }}"</li>
        @endforeach
    </ul>
@endsection