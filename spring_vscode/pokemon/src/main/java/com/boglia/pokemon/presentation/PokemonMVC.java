package com.boglia.pokemon.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.boglia.pokemon.services.PokemonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PokemonMVC {

    private final PokemonService pokemonService;

    public PokemonMVC(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("pokemon")
    public String getPokemon(Model model, @RequestParam(required = false) String type) {

        if(type != null && !type.isEmpty()) {
            model.addAttribute("pokemonList", pokemonService.getAllPokemon().stream()
                    .filter(pokemon -> type.equalsIgnoreCase(pokemon.getType1()) || type.equalsIgnoreCase(pokemon.getType2()))
                    .toList());
        } else {
            model.addAttribute("pokemonList", pokemonService.getAllPokemon());
        }

        return "pokemon";
    }
    


}
