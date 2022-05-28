package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion = null;
	private Conexion()  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.64.2:3306/sakila", "brian", "kupita");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConexion() {
		if (conexion == null) {
			new Conexion();
		}
		return conexion;
	}

	
	
}
