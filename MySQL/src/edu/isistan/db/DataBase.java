package edu.isistan.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

	public static void main(String[] args) {

		String driver = "com.mysql.cj.jdbc.Driver"; 
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		String uri = "jdbc:mysql://localhost:3306/mysql";
		try {
			Connection conn = DriverManager.getConnection(uri, "root", "");
			conn.setAutoCommit(false);
			
			String table = "CREATE TABLE persona(" 
					+ "id INT, " 
					+ "nombre VARCHAR(500),"
					+ "edad INT,"
					+ "PRIMARY KEY(id))";
			
			conn.prepareStatement(table).execute();
			conn.commit();
			
			conn.close();
			System.out.println("table created. done!!!");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return;
	}
}
