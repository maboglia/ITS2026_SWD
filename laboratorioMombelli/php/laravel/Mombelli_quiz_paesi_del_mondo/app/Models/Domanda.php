<?php

namespace App\Models;

class Domanda
{
    public function __construct(
        public string $domanda,
        public string $rispostaCorretta,
        public array $rispostaErrate = [],
        public ?string $livelloDifficolta = null,
        public ?string $categoria = null,
        public ?string $bandiera = null,
        public ?string $paese = null,
        public ?string $codicePaese = null,
    ) {
    }

    public static function fromArray(array $data): self
    {
        return new self(
            $data['domanda'] ?? '',
            $data['rispostaCorretta'] ?? '',
            $data['rispostaErrate'] ?? [],
            $data['livelloDifficolta'] ?? null,
            $data['categoria'] ?? null,
            $data['bandiera'] ?? null,
            $data['paese'] ?? null,
            $data['codicePaese'] ?? null,
        );
    }

    public function getTutteLeRisposte(): array
    {
        $risposte = array_merge(
            [$this->rispostaCorretta],
            $this->rispostaErrate
        );

        $risposte = array_values(array_unique(array_filter(
            $risposte,
            static fn ($risposta) => $risposta !== ''
        )));

        shuffle($risposte);

        return $risposte;
    }

    public function toArray(): array
    {
        return [
            'domanda' => $this->domanda,
            'rispostaCorretta' => $this->rispostaCorretta,
            'rispostaErrate' => $this->rispostaErrate,
            'livelloDifficolta' => $this->livelloDifficolta,
            'categoria' => $this->categoria,
            'bandiera' => $this->bandiera,
            'paese' => $this->paese,
            'codicePaese' => $this->codicePaese,
        ];
    }
}