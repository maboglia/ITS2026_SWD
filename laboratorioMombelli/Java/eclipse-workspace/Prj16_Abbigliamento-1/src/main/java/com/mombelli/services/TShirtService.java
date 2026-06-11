package com.mombelli.services;

import java.util.List;

import com.mombelli.model.Maglia;
import com.mombelli.model.Prodotto;

public interface TShirtService {

	List<Maglia> getMagliette();
	Maglia addMaglietta(String maglietta);
	
	List<Prodotto> getProdotti();
	List<Prodotto> getProdottiByCayegory(String Categoria);
	Prodotto addProdotto(Prodotto p);
	Prodotto updateProdotto(Prodotto p);
	Prodotto getProdottoById(int id);
	void deleteProdottoById(int id);
}
