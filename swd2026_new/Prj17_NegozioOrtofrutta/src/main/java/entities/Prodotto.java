package entities;

/**
 * Model prodotto ortofrutticolo
 */
public record Prodotto(
		int id, 
		String nome, 
		String categoria, 
		double prezzoKg, 
		String disponibilita) {}
