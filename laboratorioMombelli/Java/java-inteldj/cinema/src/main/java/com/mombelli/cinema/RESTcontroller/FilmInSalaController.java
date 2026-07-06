package com.mombelli.cinema.RESTcontroller;


import com.mombelli.cinema.service.FilmInSalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/filminsala")
public class FilmInSalaController {

    private final FilmInSalaService filmInSalaService;



}
