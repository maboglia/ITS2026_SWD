package com.mombelli.cinema.repository;

import com.mombelli.cinema.entity.FilmInSala;
import com.mombelli.cinema.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, FilmInSala> {
    List<Prenotazione> findByFilmInSalaId(Integer filmInSalaId);
}
