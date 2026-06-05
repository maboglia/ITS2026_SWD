package com.mombelli.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mombelli.entities.Automobile;
import com.mombelli.repos.AutomobiliRepo;

@Service
public class ServizioVeicoli {
	
	@Autowired
	private AutomobiliRepo repoAuto;
	
	public List<Automobile> getAutomobili(){
		return repoAuto.findAll();
	}
	
	public Automobile addAutomobile (Automobile a) {
		return repoAuto.save(a);
	}

}
