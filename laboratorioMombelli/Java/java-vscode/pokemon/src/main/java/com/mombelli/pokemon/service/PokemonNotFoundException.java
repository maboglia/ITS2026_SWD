package com.mombelli.pokemon.service;

/** Raised when a pokémon id does not exist; mapped to a friendly 404 page. */
public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(Long id) {
        super("No pokémon found with id " + id);
    }
}
