package lists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DemoArray2 {
	// in qeusto caso stai sbattendo l'eventuale problema
	// il problema andrebbe gestito ma magari non sembre ne siamo in grado noi
	public static void main(String[] args) throws FileNotFoundException {
		
		File fileMarks = new File("files/marks.txt");
		File fileOutput = new File("files/output.txt");
		
		Scanner input = new Scanner(fileMarks);
		
		PrintWriter pw = new PrintWriter(fileOutput);
		int total = 0;
		String bigString = "";
		while(input.hasNextLine()) {
			String row = input.nextLine();
			// int tipo primitivo
			// Integer è la classe, mentre parsInt è un metodo
			int mark = Integer.parseInt(row);
			total += mark;
			bigString += row;
			System.out.println(row);
		}
		System.out.println("Totale: " + total);
		pw.println("Totale: " + total);
		pw.close();
	}

}
