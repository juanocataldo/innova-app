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
				
		return listado;
	}

	@Override
	public List<Economato_Elementos> listElementosByFilters(String nombre, int estado, int tipo) {
		
		Session session = currentSession.getCurrentSession();
		
		Query<Economato_Elementos> query = null;
		
		System.out.println("INGRESAN PARAMS EN FILTROS "+nombre+" "+estado+" "+tipo);
		
		if(nombre != null) {
			query = session.createQuery("from Economato_Elementos WHERE lower(nombre) LIKE :nombre ORDER BY 1 ASC",Economato_Elementos.class);
			query.setParameter("nombre", "%"+nombre+"%");
		}
		else {
			if(tipo!=2 && estado!=2 && nombre==null) {
				query = session.createQuery("from Economato_Elementos WHERE tipo=:tipo OR estado=:estado ORDER BY 1 ASC",Economato_Elementos.class);
				query.setParameter("tipo", tipo);
				query.setParameter("estado", estado);
			}else
				query = session.createQuery("from Economato_Elementos ORDER BY 1 ASC",Economato_Elementos.class);
		}
		
		List<Economato_Elementos> listado = query.getResultList();
				
		return listado;
	}

	@Override
	public void addElemento(Economato_Elementos nuevoElemento) {
		
		Session session = currentSession.getCurrentSession();
		
		session.save(nuevoElemento);
		
	}

}
