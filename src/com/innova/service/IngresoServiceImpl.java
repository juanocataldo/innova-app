package com.innova.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.IngresoDAO;
import com.innova.entity.Ingreso;

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

}
