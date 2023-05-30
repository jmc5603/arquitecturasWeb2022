package com.dao.practicas;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		DataBase db = new DataBase("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/mysql");
		PersonaDAO dao = new PersonaDAO(db);
		
		Persona p1 = new Persona(1, 18, "Manuel", "Campo", "M");
		
		dao.insert(p1);
		
		System.out.println(dao.get(p1.getId()).getNombre());
		

	}

}
