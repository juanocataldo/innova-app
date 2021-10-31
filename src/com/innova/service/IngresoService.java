package com.innova.service;

import java.util.Date;
import java.util.List;

import com.innova.entity.Ingreso;
import com.innova.entity.IngresoEstado;

public interface IngresoService {
	
	List<Ingreso> getIngresos();

	Ingreso getLastIngreso(Integer id);
	
	Ingreso getLastTimeIngreso(int id);

	List<Ingreso> getIngresosByName(String busqueda);
	
	List<Ingreso> getIngresosById(int id);

	List<IngresoEstado> getIngresosSemaforo();
	
	IngresoEstado getIngresoByPerId(int id);

	List<IngresoEstado> getIngresosEstadosByName(String personaSearch);
}
