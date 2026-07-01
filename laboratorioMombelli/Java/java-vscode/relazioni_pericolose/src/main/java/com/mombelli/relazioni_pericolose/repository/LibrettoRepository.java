package com.mombelli.relazioni_pericolose.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mombelli.relazioni_pericolose.entities.Libretto;

public interface LibrettoRepository extends JpaRepository<Libretto, Integer> {

}
