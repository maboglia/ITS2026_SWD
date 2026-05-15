package services;

import java.util.List;

import entities.Prodotto;
import repos.ProdottoRepo;
import repos.ProdottoRepoImpl;

public class ProdottiServiceImpl implements ProdottiService{

	ProdottoRepo repo = new ProdottoRepoImpl();
	
	@Override
	public List<Prodotto> findaAll() {
		// TODO Auto-generated method stub
		return repo.getProdotti();
	}

}
