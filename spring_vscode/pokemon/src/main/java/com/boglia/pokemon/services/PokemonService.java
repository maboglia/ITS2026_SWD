package com.boglia.pokemon.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.boglia.pokemon.entities.Pokemon;
import com.boglia.pokemon.repos.PokemonRepo;

@Service
public class PokemonService {

    private final PokemonRepo pokemonRepo;

    public PokemonService(PokemonRepo pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepo.findAll();
    }

    public Set<String> getAllPokemonTypes() {
        return pokemonRepo.findAll().stream()
                .flatMap(pokemon -> Set.of(pokemon.getType1(), pokemon.getType2()).stream())
                .filter(type -> type != null && !type.isEmpty())
                .sorted()
                .collect(java.util.stream.Collectors.toSet());
    }
}
