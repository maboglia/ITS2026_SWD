package com.mombelli.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mombelli.model.Maglia;
import com.mombelli.model.Prodotto;
import com.mombelli.repos.ProdottoRepo;

@Service
public class TShirtServiceImpl implements TShirtService {

	@Autowired
	private ProdottoRepo repo;
	
	@Override
	public List<Maglia> getMagliette() {
		// TODO Auto-generated method stub
		List<Maglia> magliette = new ArrayList<Maglia>();
		
		Maglia m1 = new Maglia();
		m1.setColore("verde");
		m1.setPrezzo(5);
		m1.setLogo("pitone");

		Maglia m2 = new Maglia();
		m2.setColore("blu");
		m2.setPrezzo(50);
		m2.setLogo("pitone");
		
		Maglia m3 = new Maglia();
		m3.setColore("rosso");
		m3.setPrezzo(55);
		m3.setLogo("java");
		
		
		
		magliette.add(m1);
		magliette.add(m2);
		magliette.add(m3);
		
		return magliette;
	}

	@Override
	public Maglia addMaglietta(String maglietta) {
		// TODO Auto-generated method stub
		return null;
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
	public Prodotto getProdottoById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void deleteProdottoById(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);;
	}

	@Override
	public List<Prodotto> getProdottiByCayegory(String categoria) {
		// TODO Auto-generated method stub
		return repo.findByCategoria(categoria);
	}

}
