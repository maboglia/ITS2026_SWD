package com.mombelli.prenotazionifilm.controller;

import com.mombelli.prenotazionifilm.dto.FilmRequest;
import com.mombelli.prenotazionifilm.service.CinemaService;
import com.mombelli.prenotazionifilm.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping
    public ResponseEntity<?> getAllFilms(){
        return ResponseEntity.ok(cinemaService.getAllCinema());
    }

}
