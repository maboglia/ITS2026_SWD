package com.boglia.relazioni_pericolose.integration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boglia.relazioni_pericolose.entities.Libretto;
import com.boglia.relazioni_pericolose.entities.Studente;
import com.boglia.relazioni_pericolose.services.SegreteriaService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/studenti")
public class SegreteriaRest {

    private final SegreteriaService service;

    public SegreteriaRest(SegreteriaService service) {
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
