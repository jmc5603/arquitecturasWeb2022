package EJERCICIO1;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Turno {

	@Id
	private int id;
	
	@Column
	private Date fecha;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Persona> persona;
	
	public Turno() {
		super();
	}
	
	public Turno(int id, Date fecha) {
		this.id = id;
		this.fecha = fecha;
		this.persona = new ArrayList<>();
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Persona> getPersona() {
		ArrayList<Persona> tmp = new ArrayList<>();
		tmp.addAll(this.persona);
		return tmp;
	}

	public void addPersona(Persona p) {
		this.persona.add(p);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Turno [id=" + id + ", fecha=" + fecha + ", persona=" + persona + "]";
	}
	
}
