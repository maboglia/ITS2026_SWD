package programs;

import controller.Shelf;
import model.Book;
import util.MyScanner;

public class BookDemo {

	public static void main(String[] args) {
		
		Book book1 = new Book("Io robot", 123, 10.50);
		Book book2 = new Book("Tu robot", 223, 15.50);
		Book book3 = new Book("Egli robot", 323, 20.50);

		Shelf fantascient = new Shelf();
		
		MyScanner canon = new MyScanner();
		
//		fantascient.addBook(book1);
//		fantascient.addBook(book2);
//		fantascient.addBook(book3);
		
		boolean turn = true;
		
		while (turn) {
			addsBook(fantascient, canon);
			String answer = canon.readString("Do you want to insert other books?");
			if (answer.equalsIgnoreCase("n")) {
				turn = false;
			}
		}
		
		
		System.out.println("<ul>");
		for (Book l : fantascient.getBooks()) {
			
			System.out.println("<li>" + l.title + "</li>");
			
		}
		System.out.println("</ul>");
//		
//		System.out.println(book1.printInfoBook());
//		System.out.println(book2.printInfoBook());
//		System.out.println(book3.printInfoBook());
//		
		
	}

	private static MyScanner addsBook(Shelf fantascient, MyScanner canon) {
		
		String title = canon.readString("Write the title of the book");
		int pages = canon.readInteger("Write the number of the pages");
		double prize = canon.readDouble("How much cost the book?");
		
		Book temp = new Book(title,pages,prize);
		fantascient.addBook(temp);
		return canon;
	}

}
