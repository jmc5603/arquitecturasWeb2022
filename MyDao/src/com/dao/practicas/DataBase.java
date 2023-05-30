package com.dao.practicas;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	
	private String uri;
	private Connection actualConn;

	public DataBase(String driver, String uri) throws SQLException {
		this.getNewInstance(driver);
		this.uri = uri;
		createTable();
	}

	private void createTable() throws SQLException {
		this.openConnection();
		Connection conn = this.getConnection();
		try {
			String query = "CREATE TABLE persona ("
					+ "id INT,"
					+ "edad INT,"
					+ "nombre VARCHAR(15),"
					+ "apellido VARCHAR(15),"
					+ "genero VARCHAR(1),"
					+ "PRIMARY KEY(id))";
			conn.prepareStatement(query).execute();
			conn.commit();
			System.out.println("tabla creada...");
		} catch (SQLException e) {
			System.out.println("ya existe una tabla creada. borrando y creando una nueva...");
			this.dropTable();
			this.createTable();
			System.exit(1);
		}
		this.closeConnection();
	}

	private void dropTable() throws SQLException {
		Connection conn = this.getConnection();
		try {
			String query = "DROP TABLE persona";
			conn.prepareStatement(query).execute();
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}
		this.closeConnection();
	}

	public void getNewInstance(String driver) {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public void openConnection () throws SQLException {
		if (this.actualConn != null) {
			System.out.println("the connection is already open. no action required...");
		}
		else {
			this.actualConn = DriverManager.getConnection(this.uri, "root", "");	
			this.actualConn.setAutoCommit(false);
		}
	}
	
	public Connection getConnection() {
		return this.actualConn;
	}
	
	public void closeConnection() throws SQLException {
		if (this.actualConn != null) {
			this.actualConn.close();
			this.actualConn = null;
		}
		else {
			System.out.println("the connection is already closed. no action required...");		
		}
	}
	
	public void setDriver(String driver) {
		this.getNewInstance(driver);
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
