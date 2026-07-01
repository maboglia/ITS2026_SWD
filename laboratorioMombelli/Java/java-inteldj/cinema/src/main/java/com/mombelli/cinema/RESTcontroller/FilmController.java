package com.mombelli.cinema.RESTcontroller;


import com.mombelli.cinema.entity.Cinema;
import com.mombelli.cinema.entity.Film;
import com.mombelli.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/film")
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/all")
    public List<Film> getAllCinema(){
        return filmService.getAllFilm();
    }
}
