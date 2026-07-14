package com.mombelli.prenotazionifilm.controller;

import com.mombelli.prenotazionifilm.dto.PrenotazioneRequest;
import com.mombelli.prenotazionifilm.service.PrenotazioneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    @PostMapping
    public ResponseEntity<?> creaPrenotazione(@RequestBody PrenotazioneRequest prenotazioneRequest){
        return ResponseEntity.ok(prenotazioneService.creaPrenotazione(prenotazioneRequest));
    }
}
