package com.mombelli.pokemon.controller;

import com.mombelli.pokemon.entity.Pokemon;
import com.mombelli.pokemon.service.PokemonService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Home / listing screen: sidebar of types + paginated, filterable, searchable table.
 */
@Controller
public class HomeController {

    private static final int PAGE_SIZE = 20;

    private final PokemonService pokemonService;

    public HomeController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    /** Main page. All filters are optional query params so they compose freely. */
    @GetMapping("/")
    public String index(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Page<Pokemon> pokemonPage = pokemonService.findPage(type, q, page, PAGE_SIZE);

        model.addAttribute("types", pokemonService.getAllTypes());
        model.addAttribute("pokemonPage", pokemonPage);
        model.addAttribute("pokemons", pokemonPage.getContent());
        model.addAttribute("selectedType", type);
        model.addAttribute("query", q);
        return "index";
    }

    /**
     * Convenience URL {@code /type/{type}} required by the exercise. Delegates to the
     * same view as the home page by forwarding the selected type as a filter.
     */
    @GetMapping("/type/{type}")
    public String byType(
            @PathVariable String type,
            @RequestParam(required = false) String q,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Page<Pokemon> pokemonPage = pokemonService.findPage(type, q, page, PAGE_SIZE);

        model.addAttribute("types", pokemonService.getAllTypes());
        model.addAttribute("pokemonPage", pokemonPage);
        model.addAttribute("pokemons", pokemonPage.getContent());
        model.addAttribute("selectedType", type);
        model.addAttribute("query", q);
        return "index";
    }
}
