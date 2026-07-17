package com.mombelli.pokemon.controller;

import com.mombelli.pokemon.service.PokemonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Turns application exceptions into a single friendly error view instead of a
 * raw stack trace. Renders {@code templates/error.html}.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /** Unknown pokémon id -> 404 with a helpful message. */
    @ExceptionHandler(PokemonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(PokemonNotFoundException ex, Model model) {
        model.addAttribute("title", "Pokémon not found");
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    /** Any other unexpected failure -> 500 with a generic message. */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneric(Exception ex, Model model) {
        model.addAttribute("title", "Something went wrong");
        model.addAttribute("message", "An unexpected error occurred. Please try again.");
        return "error";
    }
}
