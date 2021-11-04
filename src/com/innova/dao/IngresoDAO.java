package com.innova.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.innova.entity.Ingreso;
import com.innova.entity.IngresoEstado;

public interface IngresoDAO {

	void ingresoPersona(Ingreso ingreso);

	List<Ingreso> getIngresos();

	List<Ingreso> getIngresosPersonas(String search);

	Ingreso getIngresoByPersonId(Integer id);

	Ingreso getLastTimeIngreso(int id);

	List<Ingreso> getIngresosByName(String busqueda);

	List<Ingreso> getIngresosById(int id);

	List<IngresoEstado> getIngresosSemaforo();

	void saveIngresoEstado(IngresoEstado ingresoEstado);

	IngresoEstado getIngresoEstadoByPersonId(int id);

	List<IngresoEstado> getIngresosEstadosByName(String personaSearch);

	List<IngresoEstado> getIngresosEstadosByDni(BigDecimal dni);

	List<IngresoEstado> getIngresosByEstado(String estado);

	List<IngresoEstado> getIngresosByFiltro(String personaSearch, BigDecimal dni, Integer estado);

	List<Ingreso> getIngresosByFecha(String fecha);
}
