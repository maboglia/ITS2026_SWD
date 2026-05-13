package todo; // tutto ciò che è nello stesso pacchetto non serve importarlo

import java.util.ArrayList;
import java.util.Scanner;// ciò che non è nello stesso pacchetto o
// non è lang (quindi System,String,Math,ecc) dev'essere importato

public class TodoList {

	public static void main(String[] args) {

		// Todo[] lista = new Todo[10]; // il limite degli array in java
		// è che quando lo crei devi già dire la sua lunghezza
		
		ArrayList<Todo> lista = new ArrayList<>();
		
		int volte = 3;
		
		for(int i = 0; i<volte;i++) {
		
			Todo t = creaTodo();
			lista.add(t);
		}
		
		for (Todo todo : lista)
		{
			System.out.println(todo.stampa());
		}
		
	}

	private static Todo creaTodo() {
		System.out.println("Cosa vuoi fare?");
		
		Scanner input = new Scanner(System.in);
		
		String risposta = input.nextLine(); // prende tutto finchè non trova invio
		
		Todo t1 = new Todo(risposta);
		
		//input.close(); // chiudere lo scanner
		
		return t1;
	}

}
