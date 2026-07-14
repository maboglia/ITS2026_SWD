package com.mombelli.prenotazionifilm.repository;

import com.mombelli.prenotazionifilm.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema,Integer> {
}
