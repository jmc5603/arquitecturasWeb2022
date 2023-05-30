package practica.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Select {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//CONSULTA EN FORMATO JPA
		System.out.println("CONSULTA EN FORMATO JPA:");
		Artista findA = em.find(Artista.class, 1);
		System.out.println(findA.toString() + "\n");
		
		//CONSULTA EN FORMATO JPQA
		System.out.println("CONSULTA EN FORMATO JPQA:");
		@SuppressWarnings("unchecked")
		List<Cancion> canciones = em.createQuery("SELECT c FROM Cancion c WHERE c.artista = 1").getResultList();
		canciones.forEach(c -> System.out.println(c));
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
