package EJERCICIO1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Domicilio {

	@Id
	private int id;
	
	@Column
	private String calle;
	
	@Column
	private String ciudad;
	
	@OneToMany(mappedBy="domicilio", fetch = FetchType.LAZY)
	private List<Persona> habitantes;
	
	public Domicilio() {
		super();
	}
	
	public Domicilio(int id, String calle, String ciudad) {
		this.id = id;
		this.calle = calle;
		this.ciudad = ciudad;
		this.habitantes = new ArrayList<>();
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Persona> getHabitantes() {
		ArrayList<Persona> tmp = new ArrayList<>();
		tmp.addAll(this.habitantes);
		return tmp;
	}

	public void addHabitante(Persona habitante) {
		this.habitantes.add(habitante);
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Domicilio [id=" + id + ", calle=" + calle + ", ciudad=" + ciudad + "]";
	}
	
	
}
