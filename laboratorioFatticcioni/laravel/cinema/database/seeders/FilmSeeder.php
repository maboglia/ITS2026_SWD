<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class FilmSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $faker = \Faker\Factory::create('it_IT');

        $generi = [
            'Azione', 'Commedia', 'Drammatico', 'Horror', 'Fantascienza',
            'Thriller', 'Animazione', 'Romantico', 'Avventura', 'Documentario',
        ];

        $titoliFilm = [
            'L\'ombra del silenzio', 'Notte senza fine', 'Il segreto di Villa Rosa',
            'Ritorno a Ferrara', 'Ultimo treno per Roma', 'Cuori in tempesta',
            'Il ladro di stelle', 'Sotto un cielo diverso', 'La stanza dei ricordi',
            'Fuga da Napoli', 'Il giardino nascosto', 'Onde di libertà',
            'Il codice perduto', 'Voci dal passato', 'Il patto dei sogni',
            'Rosso cremisi', 'L\'ultima estate', 'Il sentiero dei lupi',
            'Domani è un altro giorno', 'La città che dorme',
        ];

        foreach ($titoliFilm as $titolo) {
            DB::table('films')->insert([
                'titolo'     => $titolo,
                'regista'    => $faker->boolean(90) ? $faker->name() : null,
                'genere'     => $faker->randomElement($generi),
                'created_at' => now(),
                'updated_at' => now(),
            ]);
        }
    }
}