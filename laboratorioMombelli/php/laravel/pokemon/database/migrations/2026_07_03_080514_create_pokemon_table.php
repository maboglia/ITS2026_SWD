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
        Schema::create('pokemon', function (Blueprint $table) {
            $table->id();
            $table->integer('Pokedex Number');
            $table->string('Name');
            $table->string('Type 1')->default(null);
            $table->string('Type 2')->default(null);
            $table->integer('Total')->default(null);
            $table->integer('HP')->default(null);
            $table->integer('Attack')->default(null);
            $table->integer('Defense')->default(null);
            $table->integer('Sp Atk')->default(null);
            $table->integer('Sp Def')->default(null);
            $table->integer('Speed')->default(null);
            $table->integer('Generation')->default(null);
            $table->string('Legendary')->default(null);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pokemon');
    }
};
