@extends('layouts.app')

@section('title', 'Quiz Paesi del Mondo')

@section('content')
    <section>
        <h1>Quiz sui Paesi del Mondo</h1>
        <p>Allenati con le schede paese o prova il quiz con difficoltà variabile e storico delle risposte.</p>
    </section>

    <section class="grid">
        <article>
            <h2>Modalità Quiz</h2>
            <form action="{{ route('quiz.sessions.store') }}" method="POST">
                @csrf
                <label for="difficulty">Seleziona il livello di difficoltà</label>
                <select name="difficulty" id="difficulty">
                    <option value="">Tutti i livelli</option>
                    <option value="facile">Facile</option>
                    <option value="medio">Medio</option>
                    <option value="difficile">Difficile</option>
                </select>
                <button type="submit">Inizia una nuova sessione</button>
            </form>
        </article>

        <article>
            <h2>Modalità Allenamento</h2>
            <p>Visualizza un paese alla volta con bandiera, capitale, lingua, popolazione e continente.</p>
            <a href="{{ route('training') }}" role="button">Vai all'allenamento</a>
        </article>

        <article>
            <h2>Storico e punteggio</h2>
            <p>Le ultime sessioni completate sono archiviate qui sotto.</p>

            @if (! empty($quizSessions))
                <details open>
                    <summary>Sessioni recenti</summary>
                    <ul>
                        @foreach ($quizSessions as $quizSession)
                            <li>
                                Sessione {{ $quizSession->id }} -
                                livello {{ $quizSession->difficulty ?: 'tutti' }} -
                                punteggio {{ $quizSession->punteggio }}/{{ $quizSession->numero_domanda > 10 ? 10 : $quizSession->numero_domanda - 1 }}
                                @if($quizSession->isCompletata())
                                    - completata
                                @endif
                            </li>
                        @endforeach
                    </ul>
                </details>
            @endif
        </article>
    </section>
@endsection