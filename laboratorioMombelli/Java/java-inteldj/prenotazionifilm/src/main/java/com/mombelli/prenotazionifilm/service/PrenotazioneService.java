package com.mombelli.prenotazionifilm.service;

import com.mombelli.prenotazionifilm.dto.PrenotazioneRequest;
import com.mombelli.prenotazionifilm.entity.FilmInSala;
import com.mombelli.prenotazionifilm.entity.Prenotazione;
import com.mombelli.prenotazionifilm.repository.FilmInSalaRepository;
import com.mombelli.prenotazionifilm.repository.PrenotazioneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;
    private final FilmInSalaRepository filmInSalaRepository;

    @Transactional
    public String creaPrenotazione(PrenotazioneRequest prenotazioneRequest ) {
        FilmInSala filmInSala = filmInSalaRepository.findById(prenotazioneRequest.getFilmInsalaId())
                .orElseThrow(() -> new RuntimeException("Errore"));

        Prenotazione prenotazione = Prenotazione.builder()
                .filmInSala(filmInSala)
                .nome(prenotazioneRequest.getNome())
                .postiPrenotazioni(prenotazioneRequest.getPostiPrenotati())
                .build();

        int resultPostiDisponibili = filmInSala.getPostiRimanenti() - prenotazioneRequest.getPostiPrenotati();

        if (resultPostiDisponibili < 0)
            throw new RuntimeException("Errore non ci sono abbastanza posti");

        filmInSala.setPostiRimanenti(resultPostiDisponibili);
        prenotazioneRepository.save(prenotazione);
        return "prenotazione aggiornata";
    }
}
