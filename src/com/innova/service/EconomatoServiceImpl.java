package com.innova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.EconomatoDAO;
import com.innova.entity.EcoBienesMov;
import com.innova.entity.EcoBienesUso;
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
	
	
}
