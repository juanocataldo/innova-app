package com.innova.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.Persona;
import com.innova.entity.Personal;

@Repository
public class PersonaDAOImpl implements PersonaDAO {

	@Autowired
	SessionFactory currentSession;
	
	@Override
	public List<Persona> listPersonas() {
		
		Session session = currentSession.getCurrentSession();
		
		Query<Persona> query = session.createQuery("from Persona",Persona.class);
		
		List<Persona> listPersonas = query.getResultList();
		
		return listPersonas;
	}

	@Override
	public int countPersonas() {
		
		Session session = currentSession.getCurrentSession();
		
		long query = (long)session.createQuery("SELECT COUNT(e) FROM Persona e").getSingleResult();
		
		return (int)query;
	}

	@Override
	public Persona getPersonaByNombreOrDni(BigDecimal dni) {

		Session session = currentSession.getCurrentSession();
		
		Query<Persona> query = null;
				
		query = session.createQuery("from Persona WHERE dni=:dni",Persona.class);
		query.setParameter("dni", dni);
		
		Persona persona = query.getSingleResult();
		
		return persona;
	}

	@Override
	public int getIdByDni(Integer id) {
		
		Session session = currentSession.getCurrentSession();
		
		System.out.println("POR EJECUTAR LA QUERY DE PERID BY DNI");
		
		int query = (int)session.createQuery("SELECT p.id from Persona p WHERE p.dni="+id+"").getSingleResult();
		
		int persona = query;
		
		System.out.println("PERID "+persona);
		
		return persona;
	}

	@Override
	public Persona getIdById(int id) {
		
		Session session = currentSession.getCurrentSession();
		
		Query<Persona> query = session.createQuery("from Persona WHERE id=:id",Persona.class);
		query.setParameter("id", id);
		
		Persona persona = query.getSingleResult();
		
		return persona;
	}

	@Override
	public Personal getPersonalByPersonaId(Integer id) {

		System.out.println("ID PARA GET PERSONAL: "+id);
		Session session = currentSession.getCurrentSession();
		
		Query<Personal> query = session.createQuery("from Personal where id=:id",Personal.class);
		query.setParameter("id", id);
		
		Personal personal= query.getSingleResult();
		
		return personal;
	}

}
