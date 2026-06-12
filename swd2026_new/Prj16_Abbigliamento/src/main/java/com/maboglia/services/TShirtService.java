package com.maboglia.services;

import java.util.List;

import com.maboglia.model.Maglia;
import com.maboglia.model.Prodotto;

public interface TShirtService {

	List<Maglia> getMagliette();
	Maglia addMaglietta(Maglia maglietta);
	
	List<Prodotto> getProdotti();
	List<Prodotto> getProdottiByCategory(String categoria);
	Prodotto addProdotto(Prodotto p);
	Prodotto updateProdotto(Prodotto p);
	Prodotto getProdottoById(int id);
	void deleteProdottoById(int id);
	
	
}
