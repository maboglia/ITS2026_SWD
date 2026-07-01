<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class CinemaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $faker = \Faker\Factory::create('it_IT');

        $nomiCinema = [
            'Cinema Odeon', 'Multisala Astra', 'Cinema Modernissimo',
            'Multisala Uci', 'Cinema Ariston', 'Cinema Nuovo Sacher',
            'Multisala Fiamma', 'Cinema Eden', 'Cinema Rivoli',
            'Multisala The Space',
        ];

        foreach ($nomiCinema as $nome) {
            DB::table('cinemas')->insert([
                'nome_cinema'       => $nome,
                'indirizzo'         => $faker->streetAddress() . ', ' . $faker->city(),
                'telefono'          => $faker->numerify('0## #######'),
                'posti_disponibili' => $faker->numberBetween(80, 400),
                'created_at'        => now(),
                'updated_at'        => now(),
            ]);
        }
    }
}