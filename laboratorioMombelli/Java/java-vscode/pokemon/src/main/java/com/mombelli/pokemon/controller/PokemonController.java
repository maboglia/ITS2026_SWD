package com.mombelli.pokemon.controller;

import com.mombelli.pokemon.entity.Pokemon;
import com.mombelli.pokemon.service.PokemonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Detail screen for a single pokémon, including its PokeAPI artwork.
 */
@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{id}")
    public String detail(
            @PathVariable Long id,
            // Carried through so the "Back" button can restore the previous filter/search.
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String q,
            Model model) {

        Pokemon pokemon = pokemonService.getById(id);

        model.addAttribute("pokemon", pokemon);
        model.addAttribute("image", pokemonService.getImage(pokemon));
        model.addAttribute("selectedType", type);
        model.addAttribute("query", q);
        return "detail";
    }
}
