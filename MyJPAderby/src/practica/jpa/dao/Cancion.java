package practica.jpa.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cancion {
	
	public Cancion() {
		super();
	}
	
	public Cancion(String title, double dur, Album alb, Artista art) {
		this.titulo_cancion = title;
		this.duracion = dur;
		this.album = alb;
		this.artista = art;
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_cancion;
	
	@Column
	private String titulo_cancion;
	
	@Column double duracion;
	
	@OneToOne
	private Album album;
	
	@OneToOne
	private Artista artista;

	public String getTitulo_cancion() {
		return titulo_cancion;
	}

	public void setTitulo_cancion(String titulo_cancion) {
		this.titulo_cancion = titulo_cancion;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public int getId_cancion() {
		return id_cancion;
	}

	@Override
	public String toString() {
		return "Cancion [id_cancion=" + id_cancion + ", titulo_cancion=" + titulo_cancion + ", duracion=" + duracion
				+ ", album=" + album.getTitulo() + ", artista=" + artista.getNombre() + "]";
	}
	
	
}
