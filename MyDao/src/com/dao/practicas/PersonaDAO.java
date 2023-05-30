package com.dao.practicas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonaDAO implements DAO<Persona>{
	
	private DataBase db;
	
	public PersonaDAO (DataBase db) {
		this.db = db;
	}

	@Override
	public Persona get(int id) {
		Connection conn;
		try {
			this.db.openConnection();
			conn = this.db.getConnection();
			String query = "select * from persona where id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			db.closeConnection();
			
			return new Persona(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
		
	}

	@Override
	public List<Persona> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Persona o) {
		try {
			this.db.openConnection();
			Connection conn;
			conn = this.db.getConnection();
			String query = "INSERT INTO persona (id, edad, nombre, apellido, genero) VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, o.getId());
			ps.setInt(2, o.getEdad());
			ps.setString(3, o.getNombre());
			ps.setString(4, o.getApellido());
			ps.setString(5, o.getGenero());
			ps.executeUpdate();
			ps.close();
			conn.commit();
			
			db.closeConnection();
			System.out.println("persona agregada a la tabla");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
