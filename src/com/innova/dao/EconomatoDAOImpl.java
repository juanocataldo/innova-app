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

		Query<Economato_Elementos> query = session.createQuery("from Economato_Elementos order by nombre asc",Economato_Elementos.class);

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
		
		Query<EcoBienesUso> query = session.createQuery("from EcoBienesUso",EcoBienesUso.class);
		
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
		
		//mov.setBienId(bu);
		mov.setTipoMovId(tipoMov);
		mov.setPerId(perId);
		
		session.save(mov);
	}

	@Override
	public int editBC(int id, int stock, String nombre) {

		System.out.println("SE RECIBEN PARA EDITAR ID "+id+" Y SE PONDRA "+nombre+", "+stock+".");
		Session session = currentSession.getCurrentSession();

		Query query = session.createQuery("UPDATE Economato_Elementos e SET e.nombre=:nombre, e.stock=:stock WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("nombre", nombre);
		query.setParameter("stock", stock);

		int elemento = query.executeUpdate();
		
		return elemento;
	}

	@Override
	public Economato_Elementos getBCbyId(int id) {

		Session session = currentSession.getCurrentSession();
		
		Query<Economato_Elementos> query = session.createQuery("from Economato_Elementos where id=:id", Economato_Elementos.class);
		query.setParameter("id", id);
		
		Economato_Elementos bien = query.getSingleResult();
		
		return bien;
	}

	@Override
	public void updateBCestado(int estado, int id) {
		
		Session session = currentSession.getCurrentSession();

		Query query = session.createQuery("UPDATE Economato_Elementos s SET s.estado=:estado WHERE s.id=:id");
		query.setParameter("id", id);
		query.setParameter("estado", estado);
		
		query.executeUpdate();		
	}

	@Override
	public int editBU(int id, Integer stock, String nombre) {
		
		
		Session session = currentSession.getCurrentSession();

		Query query = session.createQuery("UPDATE EcoBienesUso e SET e.nombre=:nombre, e.stock=:stock WHERE id=:id");
		query.setParameter("id", id);
		query.setParameter("nombre", nombre);
		query.setParameter("stock", stock);

		int elemento = query.executeUpdate();
		
		return elemento;
	}

	@Override
	public void addElementoBU(EcoBienesUso nuevoElemento) {
		
		Session session = currentSession.getCurrentSession();
		
		session.save(nuevoElemento);
		
	}

	@Override
	public void updateBUestado(int estado, int id) {

		Session session = currentSession.getCurrentSession();

		Query query = session.createQuery("UPDATE EcoBienesUso s SET s.estado=:estado WHERE s.id=:id");
		query.setParameter("id", id);
		query.setParameter("estado", estado);
		
		query.executeUpdate();		
	}

	@Override
	public EcoBienesUso getBienByNameId(int id, String nombre) {

		Session session = currentSession.getCurrentSession();

		Query<EcoBienesUso> query = session.createQuery("from EcoBienesUso where id=:id AND nombre=:nombre",EcoBienesUso.class);
		query.setParameter("id", id);
		query.setParameter("nombre", nombre);

		EcoBienesUso bu = query.getSingleResult();

		return bu;
	}

	@Override
	public void saveMovBien(int tipoMov, int tipoBien, int idBien, int perid, int cant, Integer temp) {

		Session session = currentSession.getCurrentSession();
		
		EcoBienesMov mov = new EcoBienesMov();
		
		System.out.println("TEMP "+temp);
		
		if(tipoBien==1) {			
			mov.setBienBuId(idBien);
			mov.setBienBcId(null);
		}else {		
			mov.setBienBcId(idBien);
			mov.setBienBuId(null);
		}
				
		mov.setPerId(perid);
		
		mov.setTipoMovId(tipoMov);
		
		mov.setCant(cant);
		
		mov.setTemp(temp);
		
		session.save(mov);		
	}

	@Override
	public List<EcoBienesMov> listMovimientos() {

		Session session = currentSession.getCurrentSession();

		Query<EcoBienesMov> query = session.createQuery("from EcoBienesMov order by id desc",EcoBienesMov.class);

		List<EcoBienesMov> listado = query.getResultList();

		return listado;
	}

	@Override
	public int getStockBU(int id) {

		Session session = currentSession.getCurrentSession();
		
		int count = (int)session.createQuery("SELECT e.stock FROM EcoBienesUso e WHERE e.id="+id+"").getSingleResult();
		
		return (int)count;
	}

	@Override
	public void updateStock(EcoBienesUso bu) {
		
		Session session = currentSession.getCurrentSession();
		
		session.saveOrUpdate(bu);
	}

	@Override
	public Economato_Elementos getBienByNameIdBC(int id, String nombre) {

		Session session = currentSession.getCurrentSession();

		Query<Economato_Elementos> query = session.createQuery("from Economato_Elementos where id=:id AND nombre=:nombre",Economato_Elementos.class);
		query.setParameter("id", id);
		query.setParameter("nombre", nombre);

		Economato_Elementos bc = query.getSingleResult();

		return bc;
	}

	@Override
	public void updateStock(Economato_Elementos bc) {

		Session session = currentSession.getCurrentSession();
		
		session.saveOrUpdate(bc);
	}

	@Override
	public int getStockBC(int id) {

		Session session = currentSession.getCurrentSession();
		
		int count = (int)session.createQuery("SELECT e.stock FROM Economato_Elementos e WHERE e.id="+id+"").getSingleResult();
		
		return (int)count;
	}

	@Override
	public List<EcoBienesMov> listBienesCargo(Integer perid) {

		Session session = currentSession.getCurrentSession();

		Query<EcoBienesMov> query = session.createQuery("from EcoBienesMov m WHERE m.perId=:id AND m.bienUso IS NOT NULL AND m.tipoMovId=1 AND m.temp=1 AND NOT EXISTS( from EcoBienesMov n WHERE n.perId=:id AND n.bienUso IS NOT NULL AND n.tipoMovId=2 AND n.temp=0 AND n.bienUso=m.bienUso) order by 1 asc ",EcoBienesMov.class);
		query.setParameter("id", perid);
		
		List<EcoBienesMov> listado = query.getResultList();

		return listado;
	}

	@Override
	public int getBienCantCargo(Integer id, int id2) {

		Session session = currentSession.getCurrentSession();
		System.out.println("BUSCO LA CANT DEL BIEN "+ id2+" A NOMBRE DE "+id);
		int count = (int)session.createQuery("SELECT m.cant from EcoBienesMov m WHERE m.perId="+id+" AND m.tipoMovId=1 AND m.temp=1 AND m.bienBuId="+id2+" AND NOT EXISTS ( SELECT n FROM EcoBienesMov n WHERE n.perId="+id+" AND n.bienBuId="+id2+" AND n.tipoMovId=2 AND n.temp=0)").getSingleResult();
		System.out.println("A CARGO TIENE "+count);
		return (int)count;
	}

	@Override
	public void updateBienCantCargo(int cant, int buId, int perId) {


		Session session = currentSession.getCurrentSession();

		Query query = session.createQuery("UPDATE EcoBienesMov m SET m.cant=:cant WHERE m.bienBuId=:buId AND m.temp=1 AND m.tipoMovId=1 and m.perId=:perId");
		query.setParameter("cant", cant);
		query.setParameter("buId", buId);
		query.setParameter("perId", perId);

		query.executeUpdate();
		
		System.out.println("SE ACTUALIZÓ AL "+buId+" QUE TENIA "+perId+" POR LA SUMA DE "+cant+" ELEMENTOS");
		
	}
	
	

}
