package tipi;

public class CaratteriEvo {

	public static void main(String[] args) {

//		final int RIGHE = 10, COLONNE = 10;
//		
//		for (int i = 1; i <= RIGHE; i++) {
//			
//			for (int j = 1; j <= COLONNE; j++) {
//				System.out.print((char) (i * j) + "\t");
//			}
//			System.out.println();
//			
//			
//		}
		
		final int numero = 4096;
		
		for (int i = 65; i < numero; i++) {
			
			System.out.print((char) i + "   ");
			
			if (i % 20 == 0) {
				System.out.println();
			}
			
		}
		
		
		
		
		
		
		

	}

}
