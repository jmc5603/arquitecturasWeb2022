package practica.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Album {
	
	public Album() {
		super();
	}
	
	public Album(String title, Artista art, int cant) {
		this.titulo_album = title;
		this.artista = art;
		this.cant_canciones = cant;
		this.canciones = new ArrayList<Cancion>();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_album;
	
	@Column
	private String titulo_album;
	
	@OneToOne
	private Artista artista;
	
	@Column
	private int cant_canciones;
	
	@OneToMany
	private List<Cancion> canciones;

	public String getTitulo() {
		return titulo_album;
	}

	public void setTitulo_album(String titulo_album) {
		this.titulo_album = titulo_album;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public int getCant_canciones() {
		return cant_canciones;
	}

	public void setCant_canciones(int cant_canciones) {
		this.cant_canciones = cant_canciones;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void addCanciones(Cancion c) {
		this.canciones.add(c);
	}

	public int getId_album() {
		return id_album;
	}

	@Override
	public String toString() {
		return "Album [id_album=" + id_album + ", titulo_album=" + titulo_album + ", artista=" + artista.getNombre()
				+ ", cant_canciones=" + cant_canciones + ", canciones=" + canciones + "]";
	}
	
}
