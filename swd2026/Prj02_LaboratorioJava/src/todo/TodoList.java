package todo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

	public static void main(String[] args) {

		//Todo[] lista = new Todo[10];
		ArrayList<Todo> lista = new ArrayList<>();
		
		int volte = 3;
		
		for (int i = 0; i < volte; i++) {
			Todo t = creaTodo();
			lista.add(t);
		}
		
		for (Todo todo : lista) {
			System.out.println(todo);
		}
		
		

	}

	private static Todo creaTodo() {
		System.out.println("Cosa vuoi fare?");
		
		Scanner input = new Scanner(System.in);
		
		String risposta = input.nextLine();

		Todo t1 = new Todo(risposta);
		
		//input.close();//chiudo lo scanner
		
		return t1;
	}

}
