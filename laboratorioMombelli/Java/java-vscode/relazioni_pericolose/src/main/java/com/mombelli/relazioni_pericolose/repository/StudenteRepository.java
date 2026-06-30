package com.mombelli.relazioni_pericolose.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mombelli.relazioni_pericolose.entities.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {

}
