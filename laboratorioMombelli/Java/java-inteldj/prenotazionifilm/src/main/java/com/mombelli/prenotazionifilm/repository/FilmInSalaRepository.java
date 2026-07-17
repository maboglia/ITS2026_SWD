package com.mombelli.prenotazionifilm.repository;

import com.mombelli.prenotazionifilm.dto.FilmInSalaResponse;
import com.mombelli.prenotazionifilm.entity.FilmInSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmInSalaRepository extends JpaRepository<FilmInSala, Integer> {

    List<FilmInSala> findAllByFilmId(int id);

    @Query("""
            SELECT new com.mombelli.prenotazionifilm.dto.FilmInSalaResponse(
            fis.cinema.nomeCinema,
            fis.cinema.indirizzo,
            fis.cinema.telefono,
            fis.film.titolo,
            fis.film.regista,
            fis.film.genere,
            fis.data,
            fis.prezzo,
            fis.cinema.posti,
            fis.postiRimanenti,
            fis.id) 
            FROM FilmInSala fis 
            WHERE fis.film.id = :filmId
            """)
    List<FilmInSalaResponse> getAllByFilmId(int filmId);
}
