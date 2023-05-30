package EJERCICIO1;

import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Insert {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin(); //EMPEZAR CON INSERCION
		
		Domicilio d1 = new Domicilio(1,"Avellaneda", "Tandil");
		Domicilio d2 = new Domicilio(2,"Rodriguez", "Rauch");
		Persona p1 = new Persona(3,13, "Manuel", d1);
		Socio s1 = new Socio(p1, "ninio");
		Persona p2 = new Persona(4,16, "pedrito", d1);
		Socio s2 = new Socio(p2, "adulto");
		Persona p3 = new Persona(5,11, "Hernan", d2);
		Socio s3 = new Socio(p3, "anciano");
		Persona p4 = new Persona(6,34, "Roberta", d2);
		Turno t1 = new Turno(7,new Date(2023, 12, 4));
		t1.addPersona(p1);
		t1.addPersona(p3);
		Turno t2 = new Turno(8,new Date(2023, 11, 2));
		t2.addPersona(p4);
		t2.addPersona(p2);
		
		em.persist(d1);
		em.persist(d2);
		em.persist(p1);
		em.persist(p2);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(p3);
		em.persist(p4);
		em.persist(t1);
		em.persist(t2);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
