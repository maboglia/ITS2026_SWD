package com.maboglia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maboglia.entities.Automobile;
import com.maboglia.repos.AutomobiliRepo;

@Service
public class ServizoVeicoli {
	
	@Autowired
	private AutomobiliRepo repoAuto;

	public List<Automobile> getAutomobili(){
		return repoAuto.findAll();
	}

	public Automobile addAutomobile(Automobile automobile) {
		// TODO Auto-generated method stub
		return repoAuto.save(automobile);
	}
	
}
