package dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseConnection {
	public Connection databaseLink;
	
	
	public Connection getConnection() {
		String databaseName = "estoque";
		String databaseUser = "postgres";
		String databasePassword = "database";
		
		String url = "jdbc:postgresql://localhost:5432/" + databaseName;
		
		try {
			Class.forName("org.postgresql.Driver");
			databaseLink = DriverManager.getConnection(url,databaseUser, databasePassword);
			
		}catch (ClassNotFoundException  e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return databaseLink;
	}
}
