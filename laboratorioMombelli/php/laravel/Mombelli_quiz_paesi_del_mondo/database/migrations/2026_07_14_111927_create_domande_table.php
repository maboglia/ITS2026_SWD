<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('domande', function (Blueprint $table) {
            $table->id();
            $table->string('domanda');
            $table->string('rispostaCorretta');
            $table->json('rispostaErrate');
            $table->string('categoria');
            $table->enum('livelloDifficolta', ['facile', 'medio', 'difficile'])->nullable();
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('domande');
    }
};
