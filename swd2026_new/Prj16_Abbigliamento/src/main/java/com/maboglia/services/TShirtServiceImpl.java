package com.maboglia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maboglia.model.Maglia;

@Service
public class TShirtServiceImpl implements TShirtService {

	
	
	@Override
	public List<Maglia> getMagliette() {
		List<Maglia> magliette = new ArrayList<Maglia>();
		
		Maglia m1 = new Maglia();
		m1.setColore("blu");
		m1.setPrezzo(15);
		m1.setLogo("Eclipse TOP!!");
		
		Maglia m2 = new Maglia();
		m2.setColore("verde");
		m2.setPrezzo(5);
		m2.setLogo("Pitone odioso!!");
		
		Maglia m3 = new Maglia();
		m3.setColore("rosso");
		m3.setPrezzo(8);
		m3.setLogo("Viva Java!!");
		
		magliette.add(m1);
		magliette.add(m2);
		magliette.add(m3);
		
		return magliette;
	}

	@Override
	public Maglia addMaglietta(Maglia maglietta) {
		// TODO Auto-generated method stub
		return null;
	}

}
