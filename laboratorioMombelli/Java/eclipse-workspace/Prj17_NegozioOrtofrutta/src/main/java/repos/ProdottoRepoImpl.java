package repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Prodotto;

public class ProdottoRepoImpl implements ProdottoRepo {

	private final String URL = "jdbc:mysql://localhost:3306/esercitazioni";
	private final String USER = "root";
	private final String PASS = "root";
	
	
	private Connection conn;
	private Statement statement;
	private PreparedStatement ps;
	
	private ResultSet rs;
	
	public ProdottoRepoImpl() {
		
		this.connetti();
	}
	
	private void connetti() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("connesso");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
	public List<Prodotto> getProdotti() {
		List<Prodotto> prodotti = new ArrayList<>();
		
		try {
			this.statement = this.conn.createStatement();
			this.rs = this.statement.executeQuery(FIND_ALL);
			
			while (rs.next()) {
				Prodotto p = new Prodotto (
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getString("categoria"),
						rs.getString("origine"),
						rs.getDouble("prezzo_kg"),
						rs.getString("disponibilita"));
				prodotti.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prodotti;
	}

	@Override
	public List<Prodotto> getProdottoByCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prodotto> getProdottoByOrigine(String origine) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		ProdottoRepoImpl pri = new ProdottoRepoImpl();
		System.out.println(pri.getProdotti());
	}

}
