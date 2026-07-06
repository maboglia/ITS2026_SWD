package com.mombelli.cinema.service;


import com.mombelli.cinema.entity.Film;
import com.mombelli.cinema.repository.FilmInSalaRepository;
import com.mombelli.cinema.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmInSalaService {

    private final FilmInSalaRepository filmInSalaRepository;
    private final FilmRepository filmRepository;

    public List<Film> getFilmInSalaByData (LocalDate date){
        return filmInSalaRepository.findFilmInSalaByData(date);
    }
}
