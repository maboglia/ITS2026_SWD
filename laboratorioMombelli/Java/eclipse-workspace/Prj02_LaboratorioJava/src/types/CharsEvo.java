package types;

public class CharsEvo {

	public static void main(String[] args) {
//		// final = si intende la versione finale di quello che segue (costante quando si tratta di variabili)
//		final int ROWS = 10, COLUMNS = 10;
//		// costanti assegnazione valore va fatta subito
//		for (int i = 1; i <= ROWS; i++) {
//			
//			for (int j = 1; j <= COLUMNS; j++) {
//				System.out.print((char)(i * j) + "\t");
//				
//			}
//			
//			System.out.println();
//			
//		}
		
		final int number = 1024;
		
		for (int i = 65; i < number; i++) {
			
			System.out.print((char)i + "   ");
			
			if (i % 20 ==0) {
				System.out.println();
			}
			
		}

	}

}
