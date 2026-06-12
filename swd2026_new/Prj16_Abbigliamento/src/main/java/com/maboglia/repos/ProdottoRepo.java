package com.maboglia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maboglia.model.Prodotto;

public interface ProdottoRepo extends JpaRepository<Prodotto, Integer> {
	
	List<Prodotto> findByCategoria(String categoria);
	
}
