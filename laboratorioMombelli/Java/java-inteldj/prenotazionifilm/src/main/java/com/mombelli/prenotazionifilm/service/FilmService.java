package com.mombelli.prenotazionifilm.service;

import com.mombelli.prenotazionifilm.dto.FilmRequest;
import com.mombelli.prenotazionifilm.entity.Film;
import com.mombelli.prenotazionifilm.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }

    public String saveFilm(FilmRequest request){
        if (filmRepository.existsByTitolo(request.getTitolo()))
            throw new RuntimeException("questo film esiste già");

        Film film = Film.builder()
                .titolo(request.getTitolo())
                .regista(request.getRegista())
                .genere(request.getGenere())
                .build();
        filmRepository.save(film);

        return "film inserito con successo";
    }
}
