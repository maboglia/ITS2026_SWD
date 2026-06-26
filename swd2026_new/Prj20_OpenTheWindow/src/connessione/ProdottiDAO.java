package connessione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdottiDAO {

	private DBMysql db = new DBMysql();
	
	private Connection conn = null;
	
	private Statement statement;
	private PreparedStatement ps;

	public void addProdotto(
			String categoria, 
			String nomeProdotto, 
			String giacenza, 
			String prezzo) throws SQLException {
		
		this.conn = db.getConnessione();
		
		String query = """
				INSERT INTO prodotti (nome, categoria, giacenza, prezzo)
				VALUES
				(?,?,?,?);
				""";
		
		this.ps = this.conn.prepareStatement(query);
		this.ps.setString(1, nomeProdotto);
		this.ps.setString(2, categoria);
		this.ps.setString(3, giacenza);
		this.ps.setString(4, prezzo);
		
		this.ps.execute();
		
	}
	
	
}
