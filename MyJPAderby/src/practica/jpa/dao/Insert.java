package practica.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); //EMPEZAR CON INSERCION
		
		Artista a1 = new Artista("Phil Collins");
		Album al1 = new Album("No jacket required", a1, 120);
		Album al2 = new Album("Face value", a1, 210);
		Cancion c1 = new Cancion("take me home", 3, al2, a1);
		Cancion c2 = new Cancion("this must be love", 4, al2, a1);
		Cancion c3 = new Cancion("in the air tonight", 2, al1, a1);
		Cancion c4 = new Cancion("sussudio", 5, al1, a1);
		
		a1.addAlbums(al2);
		a1.addAlbums(al1);
		al1.addCanciones(c3);
		al1.addCanciones(c4);
		al2.addCanciones(c2);
		al2.addCanciones(c1);
		
		em.persist(a1);
		em.persist(al1);
		em.persist(al2);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		

	}

}
