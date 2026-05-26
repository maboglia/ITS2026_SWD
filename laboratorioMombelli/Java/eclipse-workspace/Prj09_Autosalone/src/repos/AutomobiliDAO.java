package repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Automobile;

public class AutomobiliDAO {
	
	private final String HOST = "jdbc:mysql://localhost/magazzino";
	private final String USER = "root";
	private final String PASS = "root";
	
	
	private Statement statement;
	
	private ResultSet rs;
	
	public List<Automobile> findAll() throws SQLException{
		
		List<Automobile> auto = new ArrayList<>();
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		statement = conn.createStatement();
		rs = statement.executeQuery("select * from auto");
		
		while (rs.next()) {
			String marca = rs.getString("marca");
			String modello = rs.getString("modello");
			
			Automobile a = new Automobile("auto", marca, modello);
			auto.add(a);
		}
		
		return auto;
	}

}
