package repos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProdottiDAO {

	public static void main(String[] args) {
		
		File f = new File("C:\\Users\\maikol.mombelli\\Desktop\\Bogliaccino\\ITS2026_SWD\\meet.txt");
		
		try {
			Scanner input = new Scanner(f);
			System.out.println(input.nextLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Spiacenti si è verificato un errore");
			System.err.println(e.getMessage());
			
			//e.printStackTrace();
		}

	}

}
