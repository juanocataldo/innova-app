package com.innova.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.SumAsigInv;

@Repository
public class SumAsigInvDAOImpl implements SumAsigInvDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<SumAsigInv> sumarios() {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<SumAsigInv> query = currentSession.createQuery("from SumAsigInv", SumAsigInv.class);
		
		List<SumAsigInv> sumarios = query.getResultList();
		
		return sumarios;
	}

}
