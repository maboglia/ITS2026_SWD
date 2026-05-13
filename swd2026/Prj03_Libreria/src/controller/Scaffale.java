package controller;

import java.util.ArrayList;

import model.Libro;

public class Scaffale {

	ArrayList<Libro> libri = new ArrayList<Libro>(); 
	
	public void addLibro(Libro l) {
		this.libri.add(l);
	}

	public ArrayList<Libro> getLibri(){
		return this.libri;
	}
	
	
}
