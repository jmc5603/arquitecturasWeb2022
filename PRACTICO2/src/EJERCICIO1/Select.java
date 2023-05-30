package EJERCICIO1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Select {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//recuperar todas las personas asignadas a un turno.
		System.out.println(getPersonasPorTurno(em, 7));
		
		//recuperar todas las personas asignadas a un turno, y marcar cuales de ellas son socios.
		imprimirListaPersona(getPersonasSocias(em));
		
		//recuperar todas las personas que viven en una ciudad predeterminada.
		imprimirListaPersona(getPersonasPorCiudad(em, "Tandil"));
			
	}
	
	public static void imprimirListaPersona (List<Persona> list) {
		list.forEach(p -> System.out.println(p));
	}
	
	@SuppressWarnings("unchecked")
	public static List<Persona> getPersonasPorCiudad(EntityManager em, String ciudad) {
		List<Persona> list = em.createQuery("select p from Persona p where p.domicilio in (select d.id from Domicilio d where d.ciudad = 'Tandil')")
			.getResultList();
		return list;
	}
	
	public static List<Persona> getPersonasPorTurno(EntityManager em, int idTurno) {
		Turno t = em.find(Turno.class, idTurno);
		List<Persona> lista = new ArrayList<>();
		lista.addAll(t.getPersona());
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Persona> getPersonasSocias(EntityManager em) {
		List<Persona> list = em.createQuery("select p from Persona p where p.id in (select s.id from Socio s)")
			.getResultList();
		return list;
	}
	
	public void delete(EntityManager em, int id) {
		em.createQuery("delete from Cliente c where c.dni = :dni");
		em.getTransaction().commit();
	}
		
}
