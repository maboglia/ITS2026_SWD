package com.maboglia.services;

import java.util.List;

import com.maboglia.model.Maglia;

public interface TShirtService {

	List<Maglia> getMagliette();
	Maglia addMaglietta(Maglia maglietta);
	
}
