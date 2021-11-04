package com.innova.service;

import java.math.BigDecimal;
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

	@Transactional
	@Override
	public List<Ingreso> getIngresosById(int id) {

		List<Ingreso> ingresos = ingresoDAO.getIngresosById(id);
		return ingresos;
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

	@Transactional
	@Override
	public List<IngresoEstado> getIngresosEstadosByDni(BigDecimal dni) {
		List<IngresoEstado> ingresoEstado = ingresoDAO.getIngresosEstadosByDni(dni);
		return ingresoEstado;
	}

	@Transactional
	@Override
	public List<IngresoEstado> getIngresosByEstado(String estado) {
		
		List<IngresoEstado> ingresoEstado = ingresoDAO.getIngresosByEstado(estado);
		return ingresoEstado;		
	}

	@Transactional
	@Override
	public List<IngresoEstado> getIngresosEstadosByFiltros(String personaSearch, BigDecimal dni, Integer estado) {
		List<IngresoEstado> ingresoEstado = ingresoDAO.getIngresosByFiltro(personaSearch, dni, estado);
		return ingresoEstado;
	}

	@Transactional
	@Override
	public List<Ingreso> getIngresosByFecha(String fecha) {
		List<Ingreso> ingresos = ingresoDAO.getIngresosByFecha(fecha);
		return ingresos;
	}

	

}
