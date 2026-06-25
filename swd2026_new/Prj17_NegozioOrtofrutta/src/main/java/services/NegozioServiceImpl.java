package services;

import java.util.List;

import entities.Prodotto;
import repos.ProdottoRepo;
import repos.ProdottoRepoImpl;

public class NegozioServiceImpl implements NegozioService {
	
	private ProdottoRepo repo = new ProdottoRepoImpl();
	
	@Override
	public List<Prodotto> getProdotti() {
		// TODO Auto-generated method stub
		return repo.getProdotti();
	}

	@Override
	public List<Prodotto> getProdottiByCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> getProdottiByOrigine(String origine) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
