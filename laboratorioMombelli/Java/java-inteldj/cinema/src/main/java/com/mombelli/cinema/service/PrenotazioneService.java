package com.mombelli.cinema.service;


import com.mombelli.cinema.entity.FilmInSala;
import com.mombelli.cinema.entity.Prenotazione;
import com.mombelli.cinema.repository.FilmInSalaRepository;
import com.mombelli.cinema.repository.PrenotazioneRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final FilmInSalaRepository filmInSalaRepository;

    @Transactional
    public Prenotazione createPrenotazione(Integer filmInSalaId, String nome, Integer posti){
        FilmInSala fis = filmInSalaRepository.findById(filmInSalaId)
                .orElseThrow(() -> new EntityNotFoundException("Proiezione non trovata"));


        if (posti == null || posti <= 0)
            throw new IllegalArgumentException("Numero posti non valido");
        if (fis.getPostiRimanenti() < posti)
            throw new IllegalStateException("Posti insufficienti");

        fis.setPostiRimanenti(fis.getPostiRimanenti() - posti);

        Prenotazione p = new Prenotazione();
        p.setFilmInSala(fis);
        p.setNome(nome);
        p.setPostiPrenotati(posti);
        return prenotazioneRepository.save(p);
    }
    
}
