package connessione;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMysql {
	
	private final String DB_NAME = "esercitazioni";
	private final String HOST = "jdbc:mysql://localhost/"+DB_NAME;
	private final String USER = "root";
	private final String PASS = "root";
	
	private Connection conn = null;
	
	public Connection getConnessione() {
		if (this.conn == null)
			this.connetti();
		
		return this.conn;
	}
	
	
	private void disconnetti() {
		try {
			if (this.conn != null)
				this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void connetti() {
		try {
			this.conn = DriverManager.getConnection(HOST, USER, PASS);
			System.out.println("Connessione OKKEY");
		} catch (Exception e) {
			System.err.println("Oh no! Non sei connesso");
			System.err.println(e.getMessage());
		}
	}

}
