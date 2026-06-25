package com.maboglia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maboglia.entities.Prodotto;
import com.maboglia.repos.ProdottoRepo;

@Service
public class ProdottoServiceImpl implements ProdottoService {

	private final ProdottoRepo repo;
	
	public ProdottoServiceImpl(ProdottoRepo repo) {
		this.repo = repo;
	}
	
	
	@Override
	public Optional<Prodotto> getProdotto(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Prodotto> getProdotti() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Prodotto addProdotto(Prodotto p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public Prodotto updateProdotto(Prodotto p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}

	@Override
	public void deleteProdotto(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
