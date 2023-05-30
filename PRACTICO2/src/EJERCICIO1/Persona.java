package EJERCICIO1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Persona {

	@Id
	private int id;
	
	@Column
	private int anios;
	
	@Column
	private String nombre;
	
	@ManyToOne
	private Domicilio domicilio;
	
	public Persona() {
		super();
	}
	
	public Persona(int id, int anios, String name, Domicilio dom) {
		this.id = id;
		this.anios = anios;
		this.nombre = name;
		this.domicilio = dom;
	}

	public int getAnios() {
		return anios;
	}

	public void setAnios(int anios) {
		this.anios = anios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", anios=" + anios + ", nombre=" + nombre + ", domicilio=" + domicilio + "]";
	}
}
