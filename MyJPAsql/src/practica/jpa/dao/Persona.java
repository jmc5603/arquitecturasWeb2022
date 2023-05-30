package practica.jpa.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column (nullable=false)
	private String nombre;
	
	@Column
	private int edad;
	
	@ManyToOne
	private Universidad uni;
	
	public Persona() {
		super();
	}

	public Persona(String nombre, int edad, Universidad uni) {
		this.nombre = nombre;
		this.edad = edad;
		this.uni = uni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Universidad getUni() {
		return uni;
	}

	public void setUni(Universidad uni) {
		this.uni = uni;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", uni=" + uni.getNombre() + "]";
	}
	
	
}
