package com.innova.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.Persona;

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

}
