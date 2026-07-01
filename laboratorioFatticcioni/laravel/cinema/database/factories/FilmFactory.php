<?php

namespace Database\Factories;

use App\Models\Film;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Film>
 */
class FilmFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'titolo' => $this->faker->sentence(3),
            'regista' => $this->faker->name(),
            'genere' => $this->faker->word(),
            'updated_at' => now(),
            'created_at' => now(),
        ];
    }
}
