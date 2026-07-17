package com.mombelli.pokemon.service;

import com.mombelli.pokemon.dto.PokemonImage;
import com.mombelli.pokemon.entity.Pokemon;
import com.mombelli.pokemon.repository.PokemonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * Business logic for browsing pokémon: listing, filtering by type, search,
 * pagination, single-record loading and image retrieval. Controllers stay thin.
 */
@Service
public class PokemonService {

    private final PokemonRepository repository;

    public PokemonService(PokemonRepository repository) {
        this.repository = repository;
    }

    /** Distinct, alphabetically sorted list of every type from both columns. */
    public List<String> getAllTypes() {
        return repository.findDistinctTypes().stream()
                .filter(t -> t != null && !t.isBlank())
                .sorted(Comparator.comparing(String::toLowerCase))
                .toList();
    }

    /**
     * Paginated home listing. A blank {@code type} or {@code query} disables that
     * filter. Results are always ordered by name.
     */
    public Page<Pokemon> findPage(String type, String query, int page, int size) {
        String typeFilter = normalize(type);
        String nameFilter = normalize(query);
        Pageable pageable = PageRequest.of(Math.max(page, 0), size, Sort.by("name").ascending());
        return repository.search(typeFilter, nameFilter, pageable);
    }

    /** Loads a single pokémon or throws {@link PokemonNotFoundException}. */
    public Pokemon getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }

    /**
     * Builds the pokemondb.net artwork URL from the pokémon's derived slug.
     * There is no server-side HTTP call: if the image 404s, the browser's
     * {@code onerror} handler swaps in the local placeholder.
     */
    public PokemonImage getImage(Pokemon pokemon) {
        return PokemonImage.of(pokemon.getImageUrl());
    }

    private static String normalize(String value) {
        return (value == null || value.isBlank()) ? null : value.trim();
    }
}
