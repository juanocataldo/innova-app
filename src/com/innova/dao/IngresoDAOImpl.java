package com.innova.dao;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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
		System.out.println("EN IMPL SE GUARDA "+ingreso);
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
		System.out.println("ID GETLASTTIMEINGRESO "+id);
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ingreso> query = currentSession.createQuery("from Ingreso WHERE userId=:person ORDER BY id DESC ", Ingreso.class);
		query.setParameter("person", id);
		Ingreso ingreso = query.getResultList().stream().findFirst().orElse(null); 
		System.out.println("EL ULTIMO INGRESO DE "+id+"es "+ingreso.getFechaIn());
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
			query = currentSession.createQuery("from Ingreso where userId=:perid ORDER BY 1 DESC", Ingreso.class);
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


	@Override
	public List<IngresoEstado> getIngresosEstadosByDni(BigDecimal dni) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<IngresoEstado> query = null;
		
		if(dni != null) {			
			query = currentSession.createQuery("from IngresoEstado WHERE persona.dni=:dni",IngresoEstado.class);
			
			query.setParameter("dni", dni);
		}else 
			query = currentSession.createQuery("from IngresoEstado",IngresoEstado.class);
				
		List<IngresoEstado> ingresoEstado = query.getResultList();
	
		return ingresoEstado;
	}


	@Override
	public List<IngresoEstado> getIngresosByEstado(String estado) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<IngresoEstado> query = null;
		
		if(estado != null) {			
		
			if(estado.equals("todos")) {
				query = currentSession.createQuery("from IngresoEstado",IngresoEstado.class);
			}else {
				query = currentSession.createQuery("from IngresoEstado WHERE estado=:estado",IngresoEstado.class);
				
				query.setParameter("estado", estado);	
			}
		}
		
		List<IngresoEstado> ingresoEstado = query.getResultList();
	
		return ingresoEstado;
	}


	@Override
	public List<IngresoEstado> getIngresosByFiltro(String personaSearch, BigDecimal dni, Integer estado) {
		
		System.out.println("PARAMETROS RECIBIDOS DAO IMPL: "+personaSearch + "|"+ dni + "|" + estado);
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<IngresoEstado> query = null;
				
		if(personaSearch == "" && dni == null) {
			
			if(estado == 2)
				query = currentSession.createQuery("from IngresoEstado ORDER BY 1 DESC",IngresoEstado.class);
			else {
				query = currentSession.createQuery("from IngresoEstado WHERE estado=:estado ORDER BY 1 DESC",IngresoEstado.class);
				query.setParameter("estado", estado);
			}
		}
		
		if(personaSearch == "" && dni != null) {
			query = currentSession.createQuery("from IngresoEstado WHERE estado=:estado AND persona.dni=:dni OR persona.nombre LIKE :personaSearch OR persona.apellido LIKE :personaSearch ORDER BY persona.nombre ASC",IngresoEstado.class);
			query.setParameter("estado", estado);
			query.setParameter("personaSearch", personaSearch);
			query.setParameter("dni", dni);
		}
		
		if(personaSearch != "" && dni == null) {
			query = currentSession.createQuery("from IngresoEstado WHERE estado=:estado OR persona.dni=:dni AND persona.nombre LIKE :personaSearch OR persona.apellido LIKE :personaSearch ORDER BY persona.nombre ASC",IngresoEstado.class);
			query.setParameter("estado", estado);
			query.setParameter("personaSearch", personaSearch);
			query.setParameter("dni", dni);			
		}
		
		if(personaSearch == null && dni == null && estado == null) {
			query = currentSession.createQuery("from IngresoEstado ORDER BY 1 DESC",IngresoEstado.class);
			
		}
		
		List<IngresoEstado> ingresoEstado = query.getResultList();
	
		return ingresoEstado;
	}


	@Override
	public List<Ingreso> getIngresosByFecha(String fecha) {
		
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		System.out.println("FECHAAA "+fecha);
		
		Query<Ingreso> query = currentSession.createQuery("from Ingreso WHERE fechaIn >= cast(:fecha as date) order by fechaIn ASC", Ingreso.class);
		query.setParameter("fecha", fecha);
		
		List<Ingreso> ingresos = query.getResultList();
		
		return ingresos;
	}
}

















