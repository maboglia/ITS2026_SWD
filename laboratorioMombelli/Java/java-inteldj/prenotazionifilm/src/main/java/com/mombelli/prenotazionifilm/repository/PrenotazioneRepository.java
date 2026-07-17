package com.mombelli.prenotazionifilm.repository;

import com.mombelli.prenotazionifilm.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer> {
}
