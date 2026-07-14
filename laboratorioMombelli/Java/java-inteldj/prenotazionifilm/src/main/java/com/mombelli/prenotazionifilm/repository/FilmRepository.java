package com.mombelli.prenotazionifilm.repository;

import com.mombelli.prenotazionifilm.entity.Cinema;
import com.mombelli.prenotazionifilm.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Integer> {
    boolean existsByTitolo(String titolo);
}
