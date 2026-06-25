package services;

import java.util.List;

import entities.Prodotto;

public interface NegozioServices {
	
	List<Prodotto> getProdotti();
	List<Prodotto> getProdottoByCategoria(String categoria);
	List<Prodotto> getProdottoByOrigine(String origine);

}
