package practica.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Select {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSIST");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//CONSULTA EN FORMATO JPA
		System.out.println("CONSULTA EN FORMATO JPA:");
		Persona findP = em.find(Persona.class, 1);
		System.out.println(findP.toString() + "\n");
		
		//CONSULTA EN FORMATO JPQA
		System.out.println("CONSULTA EN FORMATO JPQA:");
		@SuppressWarnings("unchecked")
		List<Persona> personas = em.createQuery("SELECT p FROM Persona p").getResultList();
		personas.forEach(p -> System.out.println(p));
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
