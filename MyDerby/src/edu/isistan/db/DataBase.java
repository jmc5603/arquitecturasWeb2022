package edu.isistan.db;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DataBase {
	
	public static void main(String[] args) {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			System.exit(1);
			e.printStackTrace();
		}
		
		String uri = "jdbc:derby:MyDerbyDb;create=true";
		
		try {
			Connection conn = DriverManager.getConnection(uri);
			//INVOCAR METODO DE CREAR TABLA PERSONA
			createTable(conn);
			//INVOCAR METODO PARA ANIADIR PERSONA
			addPersona(conn, 1, "Manuel", "M");
			//INVOCAR METODO PARA IMPRIMIR TODA LA TABLA
			selectALLpersona(conn);	
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	private static void selectALLpersona(Connection conn) throws SQLException { 
		String query = "SELECT * FROM persona";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+", "+ rs.getString(2)+", "+rs.getString(3));
		}
	}
	
	private static void addPersona(Connection conn, int id, String nombre, String genero) throws SQLException {
		String query = " INSERT INTO persona (id, nombre, genero) VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ps.setString(2, nombre);
		ps.setString(3, genero);
		ps.executeUpdate();
		ps.close();
		conn.commit();
	}

	public static void createTable(Connection conn) {
		try {
			String query = "CREATE TABLE persona ("
					+ "id INT,"
					+ "nombre VARCHAR(15),"
					+ "genero VARCHAR(1),"
					+ "PRIMARY KEY(id))";
			conn.prepareStatement(query).execute();
			conn.commit();
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
			e.printStackTrace();
		}
	}
	
}
