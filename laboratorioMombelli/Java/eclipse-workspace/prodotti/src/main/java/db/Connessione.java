package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {
	
	private final String HOST = "jdbc:mysql://localhost:3306";
	private final String USER = "root";
	private final String PASS = "root";
	private final String DATABASE = "magazzino";

	private Connection conn = null;
	
	public Connection getConn() throws SQLException {
		if (this.conn == null) {
			connetti();
		}
		return conn;
	}
	
	public void connetti() throws SQLException {
		this.conn = DriverManager.getConnection(HOST, USER, PASS);
		if (this.conn != null) {
			System.out.println("Siamo connessi!");
		} else {
			System.out.println("Qualcosa non va...");
		}
	}
	public static void main (String[] args) throws SQLException{
		
		Connessione c = new Connessione();
		c.connetti();
	}
}
