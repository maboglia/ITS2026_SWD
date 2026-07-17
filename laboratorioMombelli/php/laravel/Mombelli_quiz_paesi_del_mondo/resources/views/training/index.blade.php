@extends('layouts.app')

@section('title', 'Allenamento')

@section('content')
    <article>
        <h1>Modalità Allenamento</h1>

        @if($paese)
            <div class="grid">
                <div>
                    <h2>{{ $paese->name }}</h2>
                    <p><strong>Capitale:</strong> {{ $paese->capital ?: 'Non disponibile' }}</p>
                    <p><strong>Lingua:</strong> {{ $paese->lingua_principale ?: 'Non disponibile' }}</p>
                    <p><strong>Popolazione:</strong> {{ $paese->population ?: 'Non disponibile' }}</p>
                    <p><strong>Continente:</strong> {{ $paese->region ?: 'Non disponibile' }}</p>
                    <p><strong>Valuta:</strong> {{ $paese->valuta_principale ?: 'Non disponibile' }}</p>
                </div>

                <div>
                    @if($bandieraUrl)
                        <img src="{{ $bandieraUrl }}" alt="Bandiera di {{ $paese->name }}" style="max-width: 240px; width: 100%;">
                    @endif
                </div>
            </div>

            <p><strong>Nome nativo:</strong> {{ $paese->nativeName ?: 'Non disponibile' }}</p>
            <p><strong>Subregione:</strong> {{ $paese->subregion ?: 'Non disponibile' }}</p>
        @else
            <p>Nessun paese disponibile.</p>
        @endif

        <footer>
            <a href="{{ route('training') }}" role="button">Mostra un altro paese</a>
            <a href="{{ route('home') }}" role="button" class="secondary">Torna alla home</a>
        </footer>
    </article>
@endsection