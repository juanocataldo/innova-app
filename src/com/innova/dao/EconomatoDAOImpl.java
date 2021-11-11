package com.innova.dao;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innova.entity.EcoBienesMov;
import com.innova.entity.EcoBienesTipoMov;
import com.innova.entity.EcoBienesUso;
import com.innova.entity.Economato_Elementos;

@Repository
public class EconomatoDAOImpl implements EconomatoDAO  {

	@Autowired
	SessionFactory currentSession;
	
	
	@Override
	public List<Economato_Elementos> listElementos() {

		Session session = currentSession.getCurrentSession();

		Query<Economato_Elementos> query = session.createQuery("from Economato_Elementos order by 1 asc",Economato_Elementos.class);

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

	@Override
	public List<EcoBienesUso> listBienesUso() {

		Session session = currentSession.getCurrentSession();
		
		Query<EcoBienesUso> query = session.createQuery("from EcoBienesUso WHERE estado=1 ",EcoBienesUso.class);
		
		List<EcoBienesUso> listado = query.getResultList();
				
		return listado;
	}

	@Override
	public int countBienesUso() {

		Session session = currentSession.getCurrentSession();
		
		long count = (long)session.createQuery("SELECT COUNT(e) FROM EcoBienesUso e WHERE e.estado=1").getSingleResult();
		
		return (int)count;
	}

	
	@Override
	public List<EcoBienesUso> listBienesUsoByName(String nombre) {

		Session session = currentSession.getCurrentSession();
		
		Query<EcoBienesUso> query = null;
		
		
		if(nombre != null) {
			query = session.createQuery("from EcoBienesUso WHERE lower(nombre) LIKE :nombre AND estado=1 ORDER BY nombre ASC",EcoBienesUso.class);
			query.setParameter("nombre", "%"+nombre+"%");
		}else {
			query = session.createQuery("from EcoBienesUso ORDER BY nombre ASC",EcoBienesUso.class);
		}
		
		List<EcoBienesUso> listado = query.getResultList();
				
		return listado;
	}

	@Override
	public EcoBienesUso getBienById(Integer id) {
		
		Session session = currentSession.getCurrentSession();

		Query<EcoBienesUso> query = session.createQuery("from EcoBienesUso WHERE id=:id",EcoBienesUso.class);

		query.setParameter("id", id);
		
		EcoBienesUso elemento = query.getSingleResult();

		return elemento;
	}

	@Override
	public List<EcoBienesUso> listBienesUsoByNameExc(String nombre, List<Integer> excepciones) {
		
		Session session = currentSession.getCurrentSession();
		
		Query<EcoBienesUso> query = null;
		
		String list = Arrays.toString(excepciones.toArray()).replace("[", "").replace("]", "");
		
		System.out.println("LISTADO EXC "+list);
		
		if(excepciones.isEmpty()) {
			query = session.createQuery("from EcoBienesUso",EcoBienesUso.class);
		}else {
		
				if(nombre != null ) {
					query = session.createQuery("SELECT e from EcoBienesUso as e WHERE lower(e.nombre) LIKE :nombre AND e.estado=1 AND e.id NOT IN ("+list+") ORDER BY e.nombre ASC",EcoBienesUso.class);
					query.setParameter("nombre", "%"+nombre+"%");
					
				}else {
					query = session.createQuery("SELECT e from EcoBienesUso as e WHERE e.estado=1 AND e.id NOT IN ("+list+") ORDER BY e.nombre ASC",EcoBienesUso.class);
									
				}
			}
			
		
		
		
		List<EcoBienesUso> listado = query.getResultList();
				
		return listado;
	}
	
	
	
	@Override
	public List<EcoBienesUso> listBienesUsoByNameInc(List<Integer> excepciones) {
		
		Session session = currentSession.getCurrentSession();
		
		Query<EcoBienesUso> query = null;
		
		String list = Arrays.toString(excepciones.toArray()).replace("[", "").replace("]", "");
		
		System.out.println("LISTADO EXC "+list);
		
		if(excepciones.isEmpty()) {
			query = session.createQuery("from EcoBienesUso  WHERE id=0",EcoBienesUso.class);
		}else {		
		query = session.createQuery("SELECT e from EcoBienesUso as e WHERE e.id IN ("+list+") ORDER BY e.nombre ASC",EcoBienesUso.class);
		}
		List<EcoBienesUso> listado = query.getResultList();
				
		return listado;
	}

	@Override
	public void saveMovBu(int bu, int tipoMov, int perId) {
		
		Session session = currentSession.getCurrentSession();
		
		EcoBienesMov mov = new EcoBienesMov();
		
		mov.setBienId(bu);
		mov.setTipoMovId(tipoMov);
		mov.setPerId(perId);
		
		session.save(mov);
	}
	
	

}
