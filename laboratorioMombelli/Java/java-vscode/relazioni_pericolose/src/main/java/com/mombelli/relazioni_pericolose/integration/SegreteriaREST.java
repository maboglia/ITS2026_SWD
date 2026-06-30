package com.mombelli.relazioni_pericolose.integration;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mombelli.relazioni_pericolose.entities.Studente;
import com.mombelli.relazioni_pericolose.service.SegreteriaService;

@RestController
@RequestMapping("/api/studenti")
public class SegreteriaREST {

    private final SegreteriaService service;

    public SegreteriaREST(SegreteriaService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Studente> getStudenti() {
        return service.getStudenti();

    }

    @PostMapping("")
    public Studente addStudente(@RequestBody Studente s) {
        return service.addStudente(s, s.getLibretto());
    }

}
