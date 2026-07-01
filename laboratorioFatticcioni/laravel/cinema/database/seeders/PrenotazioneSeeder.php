<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class PrenotazioneSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $faker = \Faker\Factory::create('it_IT');

        $filmInSalas = DB::table('film_in_salas')->get(['id', 'posti_rimanenti']);

        if ($filmInSalas->isEmpty()) {
            $this->command->warn('Nessuna proiezione trovata: esegui prima FilmInSalaSeeder.');
            return;
        }

        foreach ($filmInSalas as $proiezione) {
            // Genero da 0 a 4 prenotazioni per proiezione
            $numPrenotazioni = $faker->numberBetween(0, 4);

            for ($i = 0; $i < $numPrenotazioni; $i++) {
                DB::table('prenotazionis')->insert([
                    'film_in_sala_id' => $proiezione->id,
                    'nome'            => $faker->name(),
                    'posti_prenotati' => $faker->numberBetween(1, 6),
                    'created_at'      => now(),
                    'updated_at'      => now(),
                ]);
            }
        }
    }
}