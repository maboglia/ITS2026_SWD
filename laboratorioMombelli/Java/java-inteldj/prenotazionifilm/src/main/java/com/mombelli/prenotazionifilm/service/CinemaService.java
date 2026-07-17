package com.mombelli.prenotazionifilm.service;

import com.mombelli.prenotazionifilm.entity.Cinema;
import com.mombelli.prenotazionifilm.entity.Film;
import com.mombelli.prenotazionifilm.repository.CinemaRepository;
import com.mombelli.prenotazionifilm.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema(){
        return cinemaRepository.findAll();
    }
}
