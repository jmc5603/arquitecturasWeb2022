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
public class Artista {
	
	public Artista() {
		super();
	}
	
	public Artista(String name) {
		this.nombre = name;
		this.Albums = new ArrayList<Album>();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_artista;
	
	@Column
	private String nombre;
	
	@OneToMany
	private List<Album> Albums;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Album> getAlbums() {
		return Albums;
	}

	public void addAlbums(Album al) {
		this.Albums.add(al);
	}

	public int getId_artista() {
		return id_artista;
	}

	@Override
	public String toString() {
		return "Artista [id_artista=" + id_artista + ", nombre=" + nombre + "]";
	}	
}
