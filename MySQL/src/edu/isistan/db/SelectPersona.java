package edu.isistan.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class SelectPersona {

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
			
			selectAll(conn);
			selectOne(conn, 2);
			
			conn.close();
			System.out.println("All rows printed. done!!!");
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("there is an error with one of the row's keys");
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		
		return;
	}

	private static void selectOne(Connection conn, int id) throws SQLException {
		String query = "select * from persona where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			int idPersona= rs.getInt(1);
			String nombre = rs.getString(2);
			int edad = rs.getInt(3);
			System.out.println(idPersona+" - "+nombre+" - "+edad);
		}
	}

	private static void selectAll(Connection conn) throws SQLException {
		String query = "SELECT * FROM persona";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String nombre = rs.getString(2);
			int edad = rs.getInt(3);
			System.out.println(id+" - "+nombre+" - "+edad);
		}
	}
}
