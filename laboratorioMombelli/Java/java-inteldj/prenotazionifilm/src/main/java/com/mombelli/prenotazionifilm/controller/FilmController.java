package com.mombelli.prenotazionifilm.controller;

import com.mombelli.prenotazionifilm.dto.FilmRequest;
import com.mombelli.prenotazionifilm.dto.NuovaProgrammazioneRequest;
import com.mombelli.prenotazionifilm.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService filmService;

    @GetMapping
    public ResponseEntity<?> getAllFilms(){
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @PostMapping
    public ResponseEntity<?> saveFilm(@RequestBody FilmRequest request){
        return ResponseEntity.ok(filmService.saveFilm(request));
    }
}
