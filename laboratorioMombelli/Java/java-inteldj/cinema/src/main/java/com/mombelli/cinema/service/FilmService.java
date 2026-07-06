package com.mombelli.cinema.service;


import com.mombelli.cinema.entity.Film;
import com.mombelli.cinema.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmService {

    private final FilmRepository filmRepository;

    public List<Film> getAllFilm(){
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(Integer id){
        return filmRepository.findById(id);
    }
}
