package giochi;

/**
*Classe tic tac toe, rappresenta il gioco del tris
*/
public class TicTacToe extends Object {

	
	/**
	 * player 1
	 */
	String player1 = "Umano";
	String player2 = "PC";
	
	/**
	 * Metodo per iniziare il gioco
	 * @param parametro Passa un parametro per iniziare
	 * @return Ritorna una stringa
	 */
	String gioca(String parametro) {
		return "Si gioca";
	}
	// single line comment
	
	/*
	 * multi 
	 * line
	 * comments
	 * */
	
	public static void main(String[] args) {
		// static vuol dire che quello che viene dopo è della classe non 
		// dei singoli oggetti
		// qualsiasi roba mi torni me lo devi dire, se non ritorni niente void
		// ma sono obbligato a dirlo
		TicTacToe oggetto1 = new TicTacToe();
		TicTacToe oggetto2 = new TicTacToe();
		TicTacToe oggetto3 = new TicTacToe();
		
		System.out.println(oggetto1.player1);
		
		
		System.out.println(oggetto2.player2);
		
		String s = oggetto1.gioca("mela");
		
		System.out.println(s);
		
		
	}
}


