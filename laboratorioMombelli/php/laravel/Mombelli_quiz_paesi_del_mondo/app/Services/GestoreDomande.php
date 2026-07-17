<?php

namespace App\Services;

use App\Models\Country;
use App\Models\Domanda;

class GestoreDomande
{
    public function caricaDomande()
    {
        return Country::query()->orderBy('name')->get();
    }

    public function trovaDomandaCasuale(?string $livello = null): ?Domanda
    {
        $paese = Country::query()
            ->whereNotNull('name')
            ->inRandomOrder()
            ->first();

        if (! $paese) {
            return null;
        }

        $tipiDomanda = $this->tipiDomandaDisponibili();
        $tipoDomanda = $tipiDomanda[array_rand($tipiDomanda)];

        return $this->generaDomanda($paese, $tipoDomanda, $livello);
    }

    public function trovaPaeseCasuale(): ?Country
    {
        return Country::query()
            ->whereNotNull('name')
            ->inRandomOrder()
            ->first();
    }

    private function generaDomanda(Country $paese, string $tipoDomanda, ?string $livello = null): Domanda
    {
        [$testo, $rispostaCorretta, $categoria, $bandiera] = $this->costruisciDomandaBase($paese, $tipoDomanda);
        $numeroOpzioni = $this->numeroOpzioniPerLivello($livello);
        $risposteErrate = $this->generaRisposteErrate($tipoDomanda, $rispostaCorretta, $numeroOpzioni - 1);

        return new Domanda(
            $testo,
            $rispostaCorretta,
            $risposteErrate,
            $livello,
            $categoria,
            $bandiera,
            $paese->name,
            $paese->alpha2Code
        );
    }

    private function costruisciDomandaBase(Country $paese, string $tipoDomanda): array
    {
        return match ($tipoDomanda) {
            'capital' => [
                'Qual è la capitale di ' . $paese->name . '?',
                (string) ($paese->capital ?: 'Non disponibile'),
                'Capitale',
                $paese->flag_url,
            ],
            'language' => [
                'Qual è una lingua ufficiale di ' . $paese->name . '?',
                (string) ($paese->lingua_principale ?: 'Non disponibile'),
                'Lingua',
                $paese->flag_url,
            ],
            'population' => [
                'Qual è la popolazione di ' . $paese->name . '?',
                (string) ($paese->population ?: 'Non disponibile'),
                'Popolazione',
                $paese->flag_url,
            ],
            'continent' => [
                'A quale continente appartiene ' . $paese->name . '?',
                (string) ($paese->region ?: 'Non disponibile'),
                'Continente',
                $paese->flag_url,
            ],
            'currency' => [
                'Qual è la valuta principale di ' . $paese->name . '?',
                (string) ($paese->valuta_principale ?: 'Non disponibile'),
                'Valuta',
                $paese->flag_url,
            ],
            'flag' => [
                'A quale paese appartiene questa bandiera?',
                (string) $paese->name,
                'Bandiera',
                $paese->flag_url,
            ],
            default => [
                'Qual è la capitale di ' . $paese->name . '?',
                (string) ($paese->capital ?: 'Non disponibile'),
                'Capitale',
                $paese->flag_url,
            ],
        };
    }

    private function generaRisposteErrate(string $tipoDomanda, string $rispostaCorretta, int $quantita): array
    {
        $campo = match ($tipoDomanda) {
            'capital' => 'capital',
            'language' => 'linguaPrincipale',
            'population' => 'population',
            'continent' => 'region',
            'currency' => 'valutaPrincipale',
            'flag' => 'name',
            default => 'capital',
        };

        $candidati = $this->caricaDomande()
            ->map(fn (Country $paese) => $this->estraiValore($paese, $campo))
            ->filter()
            ->reject(fn (string $valore) => trim($valore) === trim($rispostaCorretta))
            ->unique()
            ->values();

        if ($candidati->count() < $quantita) {
            $extra = $this->caricaDomande()
                ->map(fn (Country $paese) => $paese->name)
                ->filter()
                ->reject(fn (string $valore) => trim($valore) === trim($rispostaCorretta))
                ->unique()
                ->values();

            $candidati = $candidati->merge($extra)->unique()->values();
        }

        return $candidati->take($quantita)->all();
    }

    private function estraiValore(Country $paese, string $campo): ?string
    {
        return match ($campo) {
            'capital' => $paese->capital,
            'linguaPrincipale' => $paese->lingua_principale,
            'population' => $paese->population,
            'region' => $paese->region,
            'valutaPrincipale' => $paese->valuta_principale,
            'name' => $paese->name,
            default => null,
        };
    }

    private function numeroOpzioniPerLivello(?string $livello): int
    {
        return match ($livello) {
            'medio' => 4,
            'difficile' => 5,
            default => 3,
        };
    }

    private function tipiDomandaDisponibili(): array
    {
        return ['capital', 'language', 'population', 'continent', 'currency', 'flag'];
    }
}