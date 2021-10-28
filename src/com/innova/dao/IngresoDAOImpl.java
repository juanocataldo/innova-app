package com.innova.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.Ingreso;

@Repository
public class IngresoDAOImpl implements IngresoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void ingresoPersona(Ingreso ingreso) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(ingreso);		
		
	}

}
