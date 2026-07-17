<?php

namespace App\Http\Controllers;

use Illuminate\Http\RedirectResponse;
use Illuminate\Http\Request;
use Illuminate\View\View;
use App\Services\Quiz;
use App\Services\GestoreDomande;
use App\Models\QuizSession;

class QuizController extends Controller
{
    public function nuovaSessione(Request $request, Quiz $quiz): RedirectResponse
    {
        $livello = $request->input('difficulty');

        $sessionQuiz = $quiz->startNewSession($livello ?: null);

        return redirect()
            ->route('quiz', ['difficulty' => $sessionQuiz->difficulty])
            ->with('messaggio', 'Nuova sessione di quiz avviata.');
    }

    public function mostraQuiz(
        Request $request,
        GestoreDomande $gestoreDomande
        ,
        Quiz $quiz
    ): View {
        $sessionQuiz = $quiz->getCurrentSession();

        if (! $sessionQuiz) {
            $sessionQuiz = $quiz->startNewSession($request->query('difficulty'));
        }

        if ($request->filled('difficulty') && $request->query('difficulty') !== $sessionQuiz->difficulty) {
            $sessionQuiz->difficulty = $request->query('difficulty');
            $sessionQuiz->save();
        }

        $livello = $sessionQuiz->difficulty;

        $domanda = null;

        if (! $quiz->quizTerminato()) {
            $domanda = $gestoreDomande->trovaDomandaCasuale($livello);

            if ($domanda) {
                $quiz->salvaDomandaCorrente($domanda);
            }
        }

        return view('quiz.index', [
            'sessionQuiz' => $sessionQuiz,
            'domanda' => $domanda,
            'punteggio' => $quiz->getPunteggio(),
            'numeroDomanda' => $quiz->getNumeroDomanda(),
            'storicoRisposte' => $quiz->getStoricoRisposte(),
            'livello' => $livello,
            'quizTerminato' => $quiz->quizTerminato(),
            'numeroMassimoDomande' => $quiz->getNumeroMassimoDomande(),
        ]);
    }

    public function verificaRisposta(
        Request $request,
        Quiz $quiz
    ): RedirectResponse {
        if ($quiz->quizTerminato()) {
            return redirect()
                ->route('quiz')
                ->with('messaggio', 'Il quiz è già terminato.');
        }

        $domanda = $quiz->getDomandaCorrente();

        if (! $domanda) {
            return redirect()
                ->route('quiz')
                ->with('messaggio', 'Nessuna domanda attiva trovata.');
        }

        $rispostaUtente = (string) $request->input('risposta', '');

        $corretta = $quiz->verificaRisposta($domanda, $rispostaUtente);

        $quiz->registraEsito($domanda, $rispostaUtente, $corretta);
        $quiz->incrementaNumeroDomanda();

        return redirect()
            ->route('quiz', [
                'difficulty' => $quiz->getLivello(),
            ])
            ->with('esito', $corretta)
            ->with('messaggio', $quiz->quizTerminato() ? 'Quiz completato.' : ($corretta ? 'Risposta corretta.' : 'Risposta errata.'));
    }

    public function reset(Quiz $quiz): RedirectResponse
    {
        $quiz->resetQuiz();

        return redirect()
            ->route('home')
            ->with('messaggio', 'Sessione corrente resettata. Le sessioni precedenti restano salvate.');
    }
}