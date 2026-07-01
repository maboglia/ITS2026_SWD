@extends('layouts.app')
@section('content')

<h1>Prenotazioni</h1>

<table>
    <thead>
        <tr>
            <th>Film</th>
            <th>Cinema</th>
            <th>Posti Prenotati</th>
            <th>Nome</th>
        </tr>
    </thead>
    <tbody>
        @foreach ($prenotazionis as $prenotazione)
            <tr>
                <td>{{ $prenotazione->filmInSala->film->titolo }}</td>
                <td>{{ $prenotazione->filmInSala->cinema->nome_cinema }}</td>
                <td>{{ $prenotazione->posti_prenotati }}</td>
                <td>{{ $prenotazione->nome }}</td>
            </tr>
        @endforeach
    </tbody>
</table>

@endsection