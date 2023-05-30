package EJERCICIO1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Socio {

	@Id
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private Persona persona;
	
	@Column(nullable=false)
	private String tipo;
	
	public Socio() {
		super();
	}
	
	public Socio(Persona p, String tipo) {
		this.persona= p;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
	}
	
	@Override
	public String toString() {
		return "Socio [persona=" + persona + ", tipo=" + tipo + "]";
	}

}
