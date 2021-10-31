package com.innova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.IngresoDAO;
import com.innova.entity.Ingreso;
import com.innova.entity.IngresoEstado;

@Service
public class IngresoServiceImpl implements IngresoService {

	@Autowired
	IngresoDAO ingresoDAO;
	
	@Transactional
	@Override
	public List<Ingreso> getIngresos() {
	
		List<Ingreso> ingresos = ingresoDAO.getIngresos();
		
		return ingresos;
	}

	@Transactional
	@Override
	public Ingreso getLastIngreso(Integer id) {
		
		Ingreso ingreso = ingresoDAO.getIngresoByPersonId(id);
		return ingreso;
	}

	@Transactional
	@Override
	public Ingreso getLastTimeIngreso(int id) {
		
		Ingreso fecha = ingresoDAO.getLastTimeIngreso(id);
		return fecha;
	}

	@Transactional
	@Override
	public List<Ingreso> getIngresosByName(String busqueda) {
		
		List<Ingreso> ingresos = ingresoDAO.getIngresosByName(busqueda);
		return ingresos;
	}

	@Override
	public List<Ingreso> getIngresosById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<IngresoEstado> getIngresosSemaforo() {
		List<IngresoEstado> ingresos = ingresoDAO.getIngresosSemaforo();
		
		return ingresos;
	}

	@Transactional
	@Override
	public IngresoEstado getIngresoByPerId(int id) {
		
		IngresoEstado ingresoEstado = ingresoDAO.getIngresoEstadoByPersonId(id);
		
		return ingresoEstado;
	}

	@Transactional
	@Override
	public List<IngresoEstado> getIngresosEstadosByName(String personaSearch) {
		
		List<IngresoEstado> ingresoEstado = ingresoDAO.getIngresosEstadosByName(personaSearch);
		return ingresoEstado;
	}

	

}
