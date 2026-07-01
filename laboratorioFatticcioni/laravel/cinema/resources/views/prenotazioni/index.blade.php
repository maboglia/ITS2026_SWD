@extends('layouts.app')
@section('content')

<h1>Prenotazioni</h1>

<ul>
    @foreach ($prenotazionis as $prenotazione)
        <li>{{ $prenotazione->filmInSala->film->titolo }} - {{ $prenotazione->filmInSala->cinema->nome_cinema }} - {{ $prenotazione->posti_prenotati }}</li>
    @endforeach
</ul>

@endsection