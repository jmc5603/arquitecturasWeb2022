package practica.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Universidad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String nombre;
	
	@Column
	private int capacidad;
	
	@OneToMany
	private List<Persona> alumnos;
	
	public Universidad() {
		super();
	}

	public Universidad(String nombre, int capacidad) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.alumnos = new ArrayList<Persona>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public List<Persona> getAlumnos() {
		ArrayList<Persona> tmp = new ArrayList<Persona>();
		tmp.addAll(this.alumnos);
		return tmp;
	}

	public void addAlumno(Persona alumno) {
		this.alumnos.add(alumno);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Universidad [id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", alumnos=" + alumnos
				+ "]";
	}
	
}
