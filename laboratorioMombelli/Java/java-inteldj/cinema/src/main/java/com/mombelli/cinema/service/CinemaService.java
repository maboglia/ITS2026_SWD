package com.mombelli.cinema.service;

import com.mombelli.cinema.entity.Cinema;
import com.mombelli.cinema.repository.CinemaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema(){
        return cinemaRepository.findAll();
    }
}
