package com.innova.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.Ingreso;
import com.innova.entity.Persona;

@Repository
public class IngresoDAOImpl implements IngresoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public void ingresoPersona(Ingreso ingreso) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(ingreso);		
		
	}


	@Override
	public List<Ingreso> getIngresos() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = currentSession.createQuery("from Ingreso order by pi_id desc", Ingreso.class);
		
		List<Ingreso> ingresos = query.getResultList();
		
		return ingresos;
	}


	@Override
	public List<Ingreso> getIngresosPersonas(String search) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = null;
		
		if(search != null && search.trim().length() > 0) {
			query = currentSession.createQuery("SELECT DISTINCT r.PER_NOMBRE, r.PER_APELLIDO, i.PI_FECHA_HORA_INI, i.PI_FECHA_HORA_FIN FROM FPA_PORTAL.POR_INGRESO i FULL JOIN FPA_RECURSOS_HUMANOS.RH_PERSONAS r ON i.PI_PER_ID=r.PER_ID", Ingreso.class);
			
		}else {
			query = currentSession.createQuery("SELECT DISTINCT r.PER_NOMBRE, r.PER_APELLIDO, i.PI_FECHA_HORA_INI, i.PI_FECHA_HORA_FIN FROM FPA_PORTAL.POR_INGRESO i FULL JOIN FPA_RECURSOS_HUMANOS.RH_PERSONAS r ON i.PI_PER_ID=r.PER_ID", Ingreso.class);			
		}
		
		
		List<Ingreso> users = query.getResultList();

		return users;
		
	}


	@Override
	public Ingreso getIngresoByPersonId(Integer id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = currentSession.createQuery("from Ingreso WHERE PI_PER_ID=:person order by pi_id desc", Ingreso.class);
		query.setParameter("person", id);
		Ingreso ingresos = query.getResultList().stream().findFirst().orElse(null);;
		
				
		return ingresos;
	}




	@Override
	public Ingreso getLastTimeIngreso(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = currentSession.createQuery("from Ingreso WHERE userId=:person order by id desc", Ingreso.class);
		query.setParameter("person", id);
		Ingreso ingreso = query.getResultList().stream().findFirst().orElse(null); 
				
		return ingreso;		
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ingreso> getIngresosByName(String busqueda) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = null; 
		
		if(busqueda != null && busqueda.trim().length() > 0) {
			query = currentSession.createQuery("select p from Ingreso INNER JOIN Persona ON userId=id WHERE nombre LIKE :user", Ingreso.class);
			query.setParameter("user", "%"+busqueda+"%");			
		}else {
			query = currentSession.createQuery("from Ingreso order by id desc", Ingreso.class);
		}
		
		List<Ingreso> ingresos = query.getResultList();
		 
		
		return ingresos;
	}
}
