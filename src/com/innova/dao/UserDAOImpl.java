package com.innova.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innova.entity.Persona;
import com.innova.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {


	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> query = currentSession.createQuery("from User", User.class);
		
		List<User> users = query.getResultList(); 
		
		return users;
	}

 



	@Override
	public List<Persona> getUsersByName(String search) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Persona> query = null;
		
		if(search != null && search.trim().length() > 0) {
			query = currentSession.createQuery("from Persona WHERE lower(nombre) LIKE :search or lower(apellido) LIKE :search", Persona.class);
			query.setParameter("search", "%"+search.toLowerCase()+"%" );
			
		}else {
			query = currentSession.createQuery("from Persona order by nombre asc", Persona.class);			
		}
		
		
		List<Persona> users = query.getResultList();

		return users;
	}

	
	


	@Override
	public Persona getPersonaById(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<Persona> query = currentSession.createQuery("from Persona WHERE id="+id+"",Persona.class);
		
		Persona persona = query.getSingleResult();
		
		return persona;
	}





	@Override
	public User getUserById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User WHERE id="+id+"",User.class);
		
		User usuario= query.getSingleResult();
		
		return usuario;	}



	@Override
	public List<Persona> getUserByName(String personaSearch) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Persona> query = null;
		
		if(personaSearch!=null && personaSearch.trim().length()>0) {
			query = currentSession.createQuery("from Persona WHERE nombre =:user OR apellido=:user",Persona.class);
			query.setParameter("user", personaSearch.toLowerCase());
			
		}else {
			query = currentSession.createQuery("from Persona",Persona.class);
			
		}
			
		List<Persona> personas = query.getResultList();
		
		return personas;	
		
		
	}
	
	@Override
	public Persona getOneUserByName(String search) {
		

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Persona> query = null;
		
		if(search!=null && search.trim().length()>0) {
			query = currentSession.createQuery("from Persona WHERE nombre =:user OR apellido=:user",Persona.class);
			query.setParameter("user", search.toLowerCase());
			
		}else {
			System.out.println("ERROR");			
		}
			
		Persona persona = query.getSingleResult();
		
		return persona;					
	}

	
}

















