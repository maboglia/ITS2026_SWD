package repos;

import java.util.ArrayList;
import java.util.List;

import entities.Prodotto;

public class ProdottoRepoImpl implements ProdottoRepo{

	private List<Prodotto> prodotti = new ArrayList<>();
	
	@Override
	public Prodotto getProdottoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> getProdotti() {
		
		//query al database
		
		//scorro il resultSet
		
		//per ogni record creo un oggetto di tipo prodotto

		
		//aggiungo il prodotto alla lista di prodotti
		prodotti.add(new Prodotto(1, "Bici", "Rossa", 150, 10));
		prodotti.add(new Prodotto(2,"T-shirt Uomo Cotone", "Uomo", 19.99, 50));
		prodotti.add(new Prodotto(3,"T-shirt Uomo Cotone", "Uomo", 19.99, 50));
		prodotti.add(new Prodotto(4,"Giacca Uomo Invernale", "Uomo", 79.99, 30));
		prodotti.add(new Prodotto(5,"Pantaloni Uomo Slim", "Uomo", 39.99, 40));
		prodotti.add(new Prodotto(6,"Maglione Donna Cashmere", "Donna", 99.99, 20));
		prodotti.add(new Prodotto(7,"Gonna Donna Estate", "Donna", 34.99, 25));
		//ritorno la lista di prodotti
		
		return prodotti;
	}

	@Override
	public Prodotto addProdotto(Prodotto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prodotto updateProdotto(Prodotto p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProdotto(int id) {
		// TODO Auto-generated method stub
		
	}

}
