package com.mombelli.cinema.repository;

import com.mombelli.cinema.entity.Film;
import com.mombelli.cinema.entity.FilmInSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmInSalaRepository extends JpaRepository<FilmInSala ,Integer> {

    List<FilmInSala> findByFilmId(Integer filmId);   // powers the detail view (req. 3)
    List<FilmInSala> findByData(LocalDate data);
}
