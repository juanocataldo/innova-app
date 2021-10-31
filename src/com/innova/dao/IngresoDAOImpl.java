package com.innova.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.Ingreso;
import com.innova.entity.IngresoEstado;

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


	@Autowired
	UserDAO userDAO;

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingreso> getIngresosByName(String busqueda) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = null;
		
		
		if(busqueda != null && busqueda.trim().length() > 0) {
			query = currentSession.createQuery("SELECT i from Ingreso i INNER JOIN i.persona p WHERE lower(p.nombre) LIKE :user OR lower(p.apellido) LIKE :user", Ingreso.class);
			query.setParameter("user", "%"+busqueda.toLowerCase()+"%");			
		}else {
			query = currentSession.createQuery("from Ingreso order by id desc", Ingreso.class);
		}
		
		List<Ingreso> ingresos = query.getResultList();
		 
		
		return ingresos;
	}


	@Override
	public List<Ingreso> getIngresosById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = null;
		
		if(id != 0) {
			query = currentSession.createQuery("from Ingreso where userId=:perid", Ingreso.class);
			query.setParameter("perid", id);			
		}else {
			query = currentSession.createQuery("from Ingreso", Ingreso.class);
		}
		
		List<Ingreso> ingresos = query.getResultList();
		
		return ingresos;
	}


	

	@Override
	public void saveIngresoEstado(IngresoEstado ingresoEstado) {
		
		Session currentSession = sessionFactory.getCurrentSession();
			
		currentSession.saveOrUpdate(ingresoEstado);		
	}


	@Override
	public List<IngresoEstado> getIngresosSemaforo() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<IngresoEstado> query = currentSession.createQuery("from IngresoEstado",IngresoEstado.class);
		
		List<IngresoEstado> ingresoEstado = query.getResultList();
		
		return ingresoEstado;
	}


	@Override
	public IngresoEstado getIngresoEstadoByPersonId(int id) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<IngresoEstado> query = currentSession.createQuery("from IngresoEstado WHERE perid=:id",IngresoEstado.class);
		
		query.setParameter("perid", id);
		
		IngresoEstado ingresoEstado = query.getSingleResult();
	
		return ingresoEstado;
	}


	@Override
	public List<IngresoEstado> getIngresosEstadosByName(String personaSearch) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<IngresoEstado> query = null;
		
		if(personaSearch!=null && personaSearch.trim().length()>0) {
			query = currentSession.createQuery("from IngresoEstado WHERE lower(persona.nombre) LIKE :perid OR lower(persona.apellido) LIKE :perid ORDER BY persona.nombre ASC",IngresoEstado.class);
			query.setParameter("perid", "%"+personaSearch.toLowerCase()+"%");
		}else 
			query = currentSession.createQuery("from IngresoEstado ORDER BY persona.nombre ASC",IngresoEstado.class); 
		
		List<IngresoEstado> ingresoEstado = query.getResultList();
		System.out.println("SE OBTUVO "+ingresoEstado);
		return ingresoEstado;
	}
}

















