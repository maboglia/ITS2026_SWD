package com.mombelli.prenotazionifilm.service;

import com.mombelli.prenotazionifilm.dto.NuovaProgrammazioneRequest;
import com.mombelli.prenotazionifilm.dto.FilmInSalaResponse;
import com.mombelli.prenotazionifilm.entity.Cinema;
import com.mombelli.prenotazionifilm.entity.Film;
import com.mombelli.prenotazionifilm.entity.FilmInSala;
import com.mombelli.prenotazionifilm.repository.CinemaRepository;
import com.mombelli.prenotazionifilm.repository.FilmInSalaRepository;
import com.mombelli.prenotazionifilm.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmInSalaService {

    private final FilmInSalaRepository filmInSalaRepository;
    private final FilmRepository filmRepository;
    private final CinemaRepository cinemaRepository;

    public List<FilmInSalaResponse> getAllByFilmId(int idFilm){
        return filmInSalaRepository.getAllByFilmId(idFilm);
    }

    public String aggiungiNuovaProgrammazione(NuovaProgrammazioneRequest request){
        Film film = filmRepository.findById(request.getIdFilm())
                .orElseThrow(() -> new RuntimeException("Errore"));
        Cinema cinema = cinemaRepository.findById(request.getIdCinema())
                .orElseThrow(() -> new RuntimeException("Errore"));

        FilmInSala filmInSala = FilmInSala.builder()
                .cinema(cinema)
                .film(film)
                .data(request.getData())
                .prezzo(request.getPrezzo())
                .postiRimanenti(cinema.getPosti())
                .build();

        filmInSalaRepository.save(filmInSala);
        return "nuova programmazione salvata";
    }
}
