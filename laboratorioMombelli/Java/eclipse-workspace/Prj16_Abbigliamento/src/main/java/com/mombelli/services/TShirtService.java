package com.mombelli.services;

import java.util.List;

import com.mombelli.model.Maglia;

public interface TShirtService {

	List<Maglia> getMagliette();
	Maglia addMaglietta(String maglietta);
}
