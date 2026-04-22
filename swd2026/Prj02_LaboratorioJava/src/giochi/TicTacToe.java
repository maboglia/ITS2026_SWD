package giochi;


/**
 * Classe tic tac toe, rappresenta il gioco del tris
 */
public class TicTacToe {

	/**
	 * player 1
	 */
	public String player1 = "Umano";
	private String player2 = "PC";
	
	/**
	 * Metodo per iniziare il gico
	 * @param parametro Passa un parametro per iniziare
	 * @return Ritorna una stringa
	 */
	String gioca(String parametro) {
		return "Si gioca";
	}
	
	
	//single line
	
	/*
	 * multi
	 * line
	 */
	
	public static void main(String[] args) {
		TicTacToe oggetto1 = new TicTacToe();
		TicTacToe oggetto2 = new TicTacToe();
		TicTacToe oggetto3 = new TicTacToe();
		
		System.out.println(oggetto1.player1);
		
		System.out.println(oggetto2.player2);
		
		String s = oggetto1.gioca("mela");
		
		System.out.println(s);
		
		
		
	}
	
}
