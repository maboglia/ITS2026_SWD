package controller;

import java.util.ArrayList;
// se uso asterisco non è chiaro cosa uso
import model.Book;

public class Shelf {
	// array like, array normale scomodo perché devo dargli una dimensione precisa e non posso cambiarla
	ArrayList<Book> books = new ArrayList<>();
	
	public void addBook(Book l) {
		this.books.add(l);
	}
	
	public ArrayList<Book> getBooks(){
		return this.books;
	}

}
