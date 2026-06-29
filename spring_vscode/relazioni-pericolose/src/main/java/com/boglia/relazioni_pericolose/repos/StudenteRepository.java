package com.boglia.relazioni_pericolose.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boglia.relazioni_pericolose.entities.Studente;

public interface StudenteRepository extends JpaRepository<Studente, Integer> {

}
