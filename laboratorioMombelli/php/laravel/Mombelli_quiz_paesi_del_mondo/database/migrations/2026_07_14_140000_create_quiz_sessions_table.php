<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    public function up(): void
    {
        Schema::create('quiz_sessions', function (Blueprint $table) {
            $table->id();
            $table->string('token')->unique();
            $table->string('difficulty')->nullable();
            $table->unsignedInteger('punteggio')->default(0);
            $table->unsignedInteger('numero_domanda')->default(1);
            $table->json('risposte_date')->nullable();
            $table->timestamp('completata_at')->nullable();
            $table->timestamps();
        });
    }

    public function down(): void
    {
        Schema::dropIfExists('quiz_sessions');
    }
};