package com.maboglia.services;

import java.util.List;
import java.util.Optional;

import com.maboglia.entities.Prodotto;

public interface ProdottoService {

	Optional<Prodotto> getProdotto(int id);
	List<Prodotto> getProdotti();
	
	Prodotto addProdotto(Prodotto p);
	Prodotto updateProdotto(Prodotto p);
	void deleteProdotto(int id);
	
	
}
