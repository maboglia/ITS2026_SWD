package com.boglia.relazioni_pericolose.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boglia.relazioni_pericolose.entities.Libretto;

public interface LibrettoRepository extends JpaRepository<Libretto, Integer> {

}
