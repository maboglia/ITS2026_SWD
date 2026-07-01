<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class FilmInSalaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $faker = \Faker\Factory::create('it_IT');

        $filmIds   = DB::table('films')->pluck('id')->toArray();
        $cinemaIds = DB::table('cinemas')->get(['id', 'posti_disponibili']);

        if (empty($filmIds) || $cinemaIds->isEmpty()) {
            $this->command->warn('Nessun film o cinema trovato: esegui prima FilmSeeder e CinemaSeeder.');
            return;
        }

        // Per ogni cinema creo diverse proiezioni con film casuali
        foreach ($cinemaIds as $cinema) {
            $numProiezioni = $faker->numberBetween(5, 12);

            for ($i = 0; $i < $numProiezioni; $i++) {
                $postiDisponibili = $cinema->posti_disponibili;
                $postiRimanenti   = $faker->numberBetween(0, $postiDisponibili);

                DB::table('film_in_salas')->insert([
                    'film_id'         => $faker->randomElement($filmIds),
                    'cinema_id'       => $cinema->id,
                    'data'            => $faker->dateTimeBetween('-1 month', '+2 months'),
                    'posti_rimanenti' => $postiRimanenti,
                    'prezzo'          => $faker->randomFloat(2, 5, 15),
                    'created_at'      => now(),
                    'updated_at'      => now(),
                ]);
            }
        }
    }
}