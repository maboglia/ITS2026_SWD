package com.boglia.pokemon.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boglia.pokemon.entities.Pokemon;

public interface PokemonRepo extends JpaRepository<Pokemon, Integer> {

}
