package com.dao.practicas;

public class Persona {

	private int id, edad;
	private String nombre, apellido, genero;
	
	public Persona(int id, int edad, String nombre, String apellido, String genero) {
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getId() {
		return id;
	}	
}
