package com.maboglia.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maboglia.entities.Prodotto;

public interface ProdottoRepo extends JpaRepository<Prodotto, Integer> {

}
