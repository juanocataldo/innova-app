package com.innova.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.Economato_Elementos;

@Repository
public class EconomatoDAOImpl implements EconomatoDAO {

	@Autowired
	SessionFactory currentSession;
	
	@Transactional
	@Override
	public List<Economato_Elementos> listElementos() {
		
		Session session = currentSession.getCurrentSession();
		
		Query<Economato_Elementos> query = session.createQuery("from Economato_Elementos",Economato_Elementos.class);
		
		List<Economato_Elementos> listado = query.getResultList();
		
		System.out.println("LISTADO ECONOMATO " + listado);
		
		return listado;
	}

}
