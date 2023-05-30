package practica.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); //EMPEZAR CON INSERCION
		
		//LA BASE NUNCA LANZARA ERROR PORQUE LOS ID NUNCA SE REPITEN POR SER AUTOMATICOS
		Universidad uni = new Universidad("unicen", 7000);
		Persona p1 = new Persona("Manuel", 20, uni);
		Persona p2 = new Persona("Pedro", 16, uni);
		uni.addAlumno(p2); //AGREGAR ALUMNOS EN LA LISTA DE LA UNI
		uni.addAlumno(p1);
		em.persist(p2); // AGREGAR ALUMNOS A LA BASE
		em.persist(p1);
		em.persist(uni); //AGREGAR UNIVERSIDAD A LA BASE
		em.getTransaction().commit();
		em.close();
		emf.close();
		

	}

}
