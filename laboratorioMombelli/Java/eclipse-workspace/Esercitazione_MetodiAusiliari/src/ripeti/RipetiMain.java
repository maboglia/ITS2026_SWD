package ripeti;

import java.util.Scanner;


public class RipetiMain {

	public static void main(String[] args) {
		
		gestisciRipetizioni();

	}

	private static void gestisciRipetizioni() {
		System.out.println("Cosa vuoi dire?");
		
		Scanner input = new Scanner(System.in);
		
		String frase = input.nextLine(); 

		System.out.println("Quante volte vuoi ripetere?");
			
		int numeriRipetizione = input.nextInt(); 
		
		if (numeriRipetizione < 0) {
			System.out.println("ERRORE: numero negativo");
		}else {
			Ripeti r1 = new Ripeti(frase,numeriRipetizione);
		
			for (int i = 0; i < r1.numeriRipetizioni; i++) {
				System.out.println(r1.Stampa());
			}
		}
	}
}
