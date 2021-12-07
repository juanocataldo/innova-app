package com.innova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.EconomatoDAO;
import com.innova.entity.EcoBienesMov;
import com.innova.entity.EcoBienesUso;
import com.innova.entity.EcoMovLog;
import com.innova.entity.EcoTemporal;
import com.innova.entity.Economato_Elementos;

@Service
public class EconomatoServiceImpl implements EconomatoService {

	@Autowired
	EconomatoDAO economatoDAO;
	
	@Transactional
	@Override
	public List<Economato_Elementos> listElementos() {

		List<Economato_Elementos> listElementos = economatoDAO.listElementos();
		return listElementos;
	}

	@Transactional
	@Override
	public List<Economato_Elementos> listElementosByFilters(String nombre, int estado, int tipo) {
		List<Economato_Elementos> listElementos = economatoDAO.listElementosByFilters(nombre, estado, tipo);
		return listElementos;	
		}

	@Transactional
	@Override
	public void addElemento(Economato_Elementos nuevoElemento) {
		
		economatoDAO.addElemento(nuevoElemento);
		
	}

	@Transactional
	@Override
	public List<EcoBienesUso> listBienesUso() {
		
		List<EcoBienesUso> listBienesUso = economatoDAO.listBienesUso();
		return listBienesUso;
	}

	@Transactional
	@Override
	public int countBienesUso() {
		
		int total = economatoDAO.countBienesUso();
		return total;
	}

	

	@Transactional
	@Override
	public List<EcoBienesUso> listBienesUsoByName(String nombre) {

		List<EcoBienesUso> list = economatoDAO.listBienesUsoByName(nombre);
		return list;
	}

	@Transactional
	@Override
	public EcoBienesUso getBienById(Integer id) {
		
		EcoBienesUso bien = economatoDAO.getBienById(id);
		return bien;
	}

	@Transactional
	@Override
	public List<EcoBienesUso> listBienesUsoByNameExc(String nombre, List<Integer> excepciones) {
		List<EcoBienesUso> list = economatoDAO.listBienesUsoByNameExc(nombre,excepciones);
		return list;
	}

	@Transactional
	@Override
	public List<EcoBienesUso> listBienesUsoByNameInc(List<Integer> excepciones) {
		List<EcoBienesUso> list = economatoDAO.listBienesUsoByNameInc(excepciones);
		return list;
	}

	
	@Transactional
	@Override
	public void saveMovBu(int bu, int tipoMov, int perId) {
		
		economatoDAO.saveMovBu(bu,  tipoMov, perId);		
	}

	@Transactional
	@Override
	public int editBC(int id, int stock, String nombre) {
		
		int editBC = economatoDAO.editBC(id,stock,nombre);
		return editBC;
	}

	@Transactional
	@Override
	public Economato_Elementos getBCbyId(int id) {
		Economato_Elementos bien = economatoDAO.getBCbyId(id);
		return bien;
	}

	@Transactional
	@Override
	public void updateBCestado(int estado, int id) {
		
		economatoDAO.updateBCestado(estado, id);
		
	}

	@Transactional
	@Override
	public int editBU(int id, Integer stock, String nombre) {

		int editBU = economatoDAO.editBU(id,stock,nombre);
		return editBU;
	}

	@Transactional
	@Override
	public void addElementoBU(EcoBienesUso nuevoElemento) {
		
		economatoDAO.addElementoBU(nuevoElemento);
		
	}

	@Transactional
	@Override
	public void updateBUestado(int estado, int id) {
		economatoDAO.updateBUestado(estado, id);
		
	}

	@Transactional
	@Override
	public EcoBienesUso getBienByNameId(int id, String nombre) {
		
		EcoBienesUso bu = economatoDAO.getBienByNameId(id,nombre);
		return bu;
	}

	@Transactional
	@Override
	public void saveMovBien(int mov, int tipoBien, int idBien, int perid, int cant, Integer temp) {
		
		economatoDAO.saveMovBien(mov, tipoBien,idBien, perid, cant, temp);
		
	}

	@Transactional
	@Override
	public List<EcoBienesMov> listMovimientos() {

		List<EcoBienesMov> listMovs = economatoDAO.listMovimientos();
		return listMovs;
	}

	@Transactional
	@Override
	public int getStockBU(int id) {
		
		int cant = economatoDAO.getStockBU(id);
		return cant;
	}

	@Transactional
	@Override
	public void updateStockBU(EcoBienesUso bu) {
		
		economatoDAO.updateStock(bu);
		
	}

	@Transactional
	@Override
	public Economato_Elementos getBienByNameIdBC(int id, String nombre) {
		Economato_Elementos bc = economatoDAO.getBienByNameIdBC(id,nombre);
		return bc;
	}

	@Transactional
	@Override
	public void updateStockBC(Economato_Elementos bc) {

		economatoDAO.updateStock(bc);		
	}

	@Transactional
	@Override
	public int getStockBC(int id) {
		int cant = economatoDAO.getStockBC(id);
		return cant;
	}

	@Transactional
	@Override
	public List<EcoTemporal> listBienesCargo(Integer id) {
		
		List<EcoTemporal> mov = economatoDAO.listBienesCargo(id);
		return mov;
	}

	@Transactional
	@Override
	public int getBienCantCargo(Integer id, int id2) {
		int mov = economatoDAO.getBienCantCargo(id, id2);
		return mov;
	}

	@Transactional
	@Override
	public void updateBienCantCargo(int id, int id2, int id3) {

		economatoDAO.updateBienCantCargo(id,id2, id3);
		
	}

	@Transactional
	@Override
	public void saveTemporal(int id, int id2, int cant, int tipoMov) {
		
		economatoDAO.saveTemporal(id, id2, cant, tipoMov);
	}

	@Transactional
	@Override
	public EcoBienesMov getMovById(int id) {
		EcoBienesMov mov = economatoDAO.getMovById(id);
		return mov;
	}

	@Transactional
	@Override
	public Integer getLastIdMov() {
		
		Integer id = economatoDAO.getLastIdMov();
		return id;		
	}

	@Transactional
	@Override
	public Integer getLastIdMovLog() {
		Integer id = economatoDAO.getLastIdMovLog();
		return id;	
	}

	@Transactional
	@Override
	public void saveMovLog(EcoMovLog movLog) {
		
		economatoDAO.saveMovLog(movLog);
		
	}
	
	
}
