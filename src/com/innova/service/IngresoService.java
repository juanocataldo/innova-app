package com.innova.service;

import java.util.Date;
import java.util.List;

import com.innova.entity.Ingreso;

public interface IngresoService {
	
	List<Ingreso> getIngresos();

	Ingreso getLastIngreso(Integer id);
	
	Ingreso getLastTimeIngreso(int id);

	List<Ingreso> getIngresosByName(String busqueda);
}
