package com.mombelli.prenotazionifilm.controller;

import com.mombelli.prenotazionifilm.dto.NuovaProgrammazioneRequest;
import com.mombelli.prenotazionifilm.service.FilmInSalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/filminsala")
public class FilmInSalaController {

    private final FilmInSalaService filmInSalaService;

    @GetMapping("{idFilm}")
    public ResponseEntity<?> getAllByFilmId(@PathVariable int idFilm){
        return ResponseEntity.ok(filmInSalaService.getAllByFilmId(idFilm));
    }

    @PostMapping
    public ResponseEntity<?> aggiungiNuovaProgrammazione(@RequestBody NuovaProgrammazioneRequest request){
        return ResponseEntity.ok(filmInSalaService.aggiungiNuovaProgrammazione(request));
    }


}
