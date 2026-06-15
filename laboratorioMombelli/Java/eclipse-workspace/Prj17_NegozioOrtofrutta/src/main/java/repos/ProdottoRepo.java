package repos;

import java.util.List;

import entities.Prodotto;

public interface ProdottoRepo {
	
	String TABLE = "prodotti_ortofrutticoli";
	String FIND_ALL = "SELECT * FROM prodotti_ortofrutticoli";
	String FIND_BY_CAT = "SELECT * FROM " + TABLE + "Where categoria = ?";
	String FIND_BY_ORIGIN = "SELECT * FROM " + TABLE + "Where origine = ?";

	
	List<Prodotto> getProdotti();
	List<Prodotto> getProdottoByCategoria(String categoria);
	List<Prodotto> getProdottoByOrigine(String origine);
	
	
}
