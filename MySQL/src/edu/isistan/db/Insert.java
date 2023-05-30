package edu.isistan.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class Insert {

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
			
			InsertPersona(conn,2,"Pedro",16);
			
			conn.close();
			System.out.println("row added. done!!!");
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("there is an error with one of the row's keys");
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		
		return;
	}

	private static void InsertPersona(Connection conn ,int id, String nombre, int edad) throws SQLException {
		String query = "INSERT INTO persona (id, nombre, edad) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ps.setInt(3, edad);
		ps.setString(2, nombre);
		ps.executeUpdate();
		ps.close();
		conn.commit();
		
		
	}
}
