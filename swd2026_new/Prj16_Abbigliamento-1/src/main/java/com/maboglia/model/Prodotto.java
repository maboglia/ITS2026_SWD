package com.maboglia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prodotti")
@Data
public class Prodotto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String nome;
    private String categoria;
    private double prezzo;
    private int giacenza;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", prezzo=" + prezzo
				+ ", giacenza=" + giacenza + "]";
	}
	public String getNome() {
		return nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public int getGiacenza() {
		return giacenza;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}
    
	
    
	
}
