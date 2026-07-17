@extends('layouts.app')

@section('title', 'Quiz')

@section('content')
    <article>
        <header>
            <strong>
                @if($quizTerminato)
                    Quiz completato
                @else
                    Domanda {{ $numeroDomanda }} di {{ $numeroMassimoDomande }}
                @endif
            </strong>
            <span style="float:right">Punteggio: {{ $punteggio }}</span>
        </header>

        <h1>Modalità Quiz</h1>

        @if($quizTerminato)
            <p>Hai completato tutte le {{ $numeroMassimoDomande }} domande previste.</p>
            <p><strong>Punteggio finale:</strong> {{ $punteggio }}</p>

            @if(! empty($storicoRisposte))
                <details open>
                    <summary>Riepilogo risposte</summary>
                    <ul>
                        @foreach($storicoRisposte as $risposta)
                            <li>
                                {{ $risposta['domanda'] }} -
                                {{ $risposta['corretta'] ? 'corretta' : 'errata' }}
                            </li>
                        @endforeach
                    </ul>
                </details>
            @endif
        @elseif($domanda)
            <p><strong>Livello:</strong> {{ $livello ?: 'tutti i livelli' }}</p>
            <p>{{ $domanda->domanda }}</p>

            @if($domanda->bandiera && $domanda->categoria === 'Bandiera')
                <figure>
                    <img src="{{ $domanda->bandiera }}" alt="Bandiera da indovinare" style="max-width: 220px;">
                </figure>
            @endif

            <form action="{{ route('quiz.answer') }}" method="POST">
                @csrf
                @foreach($domanda->getTutteLeRisposte() as $risposta)
                    <label>
                        <input type="radio" name="risposta" value="{{ $risposta }}" required>
                        {{ $risposta }}
                    </label>
                @endforeach

                <button type="submit">Conferma risposta</button>
            </form>
        @else
            <p>Nessuna domanda disponibile al momento.</p>
        @endif

        <footer>
            <form action="{{ route('quiz.reset') }}" method="POST" style="display:inline">
                @csrf
                <button type="submit" class="secondary">Reset quiz</button>
            </form>
            <a href="{{ route('home') }}" role="button" class="secondary">Torna alla home</a>
        </footer>
    </article>
@endsection