package tuttiuguali;

import java.util.Scanner;

public class TuttiUgualiMain {

	public static void main(String[] args) {
		
		gestisciUguaglianza();

	}
	private static void gestisciUguaglianza() {
		TuttiUguali t = new TuttiUguali();
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 3 ; i++) {
			System.out.println("Dimmi un numero?");
			int numero = input.nextInt();
			switch (i) {
			case 0:
				t.setNumero1(numero);
				break;
			case 1:
				t.setNumero2(numero);
				break;
			case 2:
				t.setNumero3(numero);
				break;
			}

		}
		if (t.Numero1 == t.Numero2 && t.Numero2 == t.Numero3){
			System.out.println(t.Stampa(true));
		}else {
			System.out.println(t.Stampa(false));
		}
	}
}
