@extends('layouts.app')

@section('title')

@endsection

@section('content')

    <h1>📚 Modalità Allenamento</h1>

<p>
    In questa modalità puoi consultare tutte le domande e le relative risposte.
</p>

@foreach($domande as $domanda)

    <div class="card">

        <h3>{{ $domanda->domanda }}</h3>

        <p>
            <strong>Difficoltà:</strong>
            {{ $domanda->livelloDifficolta ?? 'Non specificata' }}
        </p>

        <p class="corretta">
            ✅ Risposta corretta:
            {{ $domanda->rispostaCorretta }}
        </p>

        <p>❌ Risposte errate:</p>

        <ul>
            @foreach($domanda->rispostaErrate as $risposta)
                <li class="risposta">
                    {{ $risposta }}
                </li>
            @endforeach
        </ul>

    </div>

@endforeach

<a href="{{ route('home') }}" class="btn">
    Torna alla Home
</a>

@endsection