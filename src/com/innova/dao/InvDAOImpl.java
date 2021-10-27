package com.innova.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.Sumarios;

@Repository
public class InvDAOImpl implements InvDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Sumarios> getSumarios() {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Sumarios> query = currentSession.createQuery("from Sumarios", Sumarios.class); 
		
		List<Sumarios> sumarios = query.getResultList();
		
		return sumarios;
	}

}
;