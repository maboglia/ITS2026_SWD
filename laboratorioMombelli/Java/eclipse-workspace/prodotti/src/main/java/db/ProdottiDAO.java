package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdottiDAO {
	
	private Connessione connessione = new Connessione();
	
	// specie di busta dove mettiamo le istruzioni
	private Statement statement;
	
	private ResultSet rs;
	
	public void stampaProdotti() throws SQLException {
		
		String query ="SELECT * FROM magazzino.prodotti";
		
		statement = connessione.getConn().createStatement();
	
		rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			String nome = rs.getString("nome");
			double prezzo = rs.getDouble("prezzo_unitario");
			
			System.out.println("Prodotto" + nome + "Prezzo £" + prezzo);
		}
	
	}
	
	public static void main(String[] args) throws SQLException {
		
		ProdottiDAO dao = new ProdottiDAO();
		dao.stampaProdotti();
	}
	
	
	

}
