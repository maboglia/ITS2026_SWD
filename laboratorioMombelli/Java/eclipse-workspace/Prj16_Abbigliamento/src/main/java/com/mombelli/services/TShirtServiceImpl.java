package com.mombelli.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mombelli.model.Maglia;

@Service
public class TShirtServiceImpl implements TShirtService {

	
	
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

}
