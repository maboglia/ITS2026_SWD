package com.mombelli.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mombelli.model.Prodotto;

public interface ProdottoRepo extends JpaRepository<Prodotto, Integer> {

	
	List<Prodotto> findByCategoria(String categoria);
}
