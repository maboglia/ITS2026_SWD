package com.mombelli.cinema.RESTcontroller;

import com.mombelli.cinema.entity.Cinema;
import com.mombelli.cinema.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping("/all")
    public List<Cinema> getAllCinema(){
        return cinemaService.getAllCinema();
    }

}
