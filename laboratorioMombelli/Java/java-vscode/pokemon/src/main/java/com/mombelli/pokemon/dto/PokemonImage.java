package com.mombelli.pokemon.dto;

/**
 * View-facing result of a PokeAPI image lookup.
 *
 * @param imageUrl    resolved artwork/sprite URL, or the local placeholder path
 * @param placeholder true when the external image could not be retrieved
 */
public record PokemonImage(String imageUrl, boolean placeholder) {

    public static final String PLACEHOLDER_PATH = "/img/placeholder.svg";

    public static PokemonImage of(String url) {
        return new PokemonImage(url, false);
    }

    public static PokemonImage usePlaceholder() {
        return new PokemonImage(PLACEHOLDER_PATH, true);
    }
}
