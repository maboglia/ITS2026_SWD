package repos;

import java.util.ArrayList;
import java.util.List;

import entities.Prodotto;

public interface ProdottoRepo {

	Prodotto getProdottoById(int id);
	List<Prodotto> getProdotti();
	Prodotto addProdotto(Prodotto p);
	Prodotto updateProdotto(Prodotto p);
	void deleteProdotto(int id);
	
}
