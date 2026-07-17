<?php

namespace App\Services;

use App\Models\Domanda;
use App\Models\QuizSession;
use Illuminate\Support\Str;

class Quiz
{
    private const MAX_DOMANDE = 10;

    public function getCurrentSession(): ?QuizSession
    {
        $token = session('quiz_session_token');

        if (! is_string($token) || $token === '') {
            return null;
        }

        return QuizSession::query()->where('token', $token)->first();
    }

    public function startNewSession(?string $livello = null): QuizSession
    {
        $sessionQuiz = QuizSession::create([
            'token' => (string) Str::uuid(),
            'difficulty' => $livello,
            'punteggio' => 0,
            'numero_domanda' => 1,
            'risposte_date' => [],
            'completata_at' => null,
        ]);

        session([
            'quiz_session_token' => $sessionQuiz->token,
        ]);

        return $sessionQuiz;
    }

    public function getPunteggio(): int
    {
        return (int) ($this->getCurrentSession()?->punteggio ?? 0);
    }

    public function getNumeroDomanda(): int
    {
        return (int) ($this->getCurrentSession()?->numero_domanda ?? 1);
    }

    public function getLivello(): ?string
    {
        return $this->getCurrentSession()?->difficulty;
    }

    public function salvaDomandaCorrente(Domanda $domanda): void
    {
        $sessionQuiz = $this->getCurrentSession();

        if (! $sessionQuiz) {
            return;
        }

        session(['quiz_domanda_corrente' => $domanda->toArray()]);
    }

    public function getDomandaCorrente(): ?Domanda
    {
        $domanda = session('quiz_domanda_corrente');

        if (! is_array($domanda)) {
            return null;
        }

        return Domanda::fromArray($domanda);
    }

    public function verificaRisposta(
        Domanda $domanda,
        string $rispostaUtente
    ): bool {
        return trim($rispostaUtente) === trim($domanda->rispostaCorretta);
    }

    public function registraEsito(Domanda $domanda, string $rispostaUtente, bool $corretta): void
    {
        $sessionQuiz = $this->getCurrentSession();

        if (! $sessionQuiz) {
            return;
        }

        $storico = $sessionQuiz->risposte_date ?? [];

        $storico[] = [
            'domanda' => $domanda->domanda,
            'rispostaUtente' => $rispostaUtente,
            'rispostaCorretta' => $domanda->rispostaCorretta,
            'corretta' => $corretta,
            'categoria' => $domanda->categoria,
        ];

        $sessionQuiz->risposte_date = $storico;

        if ($corretta) {
            $sessionQuiz->punteggio = $this->getPunteggio() + 1;
        }

        $sessionQuiz->save();
    }

    public function incrementaNumeroDomanda(): void
    {
        $sessionQuiz = $this->getCurrentSession();

        if (! $sessionQuiz) {
            return;
        }

        $sessionQuiz->numero_domanda = $this->getNumeroDomanda() + 1;

        if ($sessionQuiz->numero_domanda > self::MAX_DOMANDE) {
            $sessionQuiz->forceFill([
                'completata_at' => now(),
            ]);
        }

        $sessionQuiz->save();
    }

    public function getStoricoRisposte(): array
    {
        return $this->getCurrentSession()?->risposte_date ?? [];
    }

    public function quizTerminato(): bool
    {
        $sessionQuiz = $this->getCurrentSession();

        if (! $sessionQuiz) {
            return false;
        }

        return $sessionQuiz->completata_at !== null || $sessionQuiz->numero_domanda > self::MAX_DOMANDE;
    }

    public function getNumeroMassimoDomande(): int
    {
        return self::MAX_DOMANDE;
    }

    public function resetQuiz(): void
    {
        session()->forget(['quiz_domanda_corrente']);
    }
}