package com.innova.dao;

import java.util.Date;
import java.util.List;

import com.innova.entity.Ingreso;

public interface IngresoDAO {

	void ingresoPersona(Ingreso ingreso);

	List<Ingreso> getIngresos();

	List<Ingreso> getIngresosPersonas(String search);

	Ingreso getIngresoByPersonId(Integer id);

	Ingreso getLastTimeIngreso(int id);

	List<Ingreso> getIngresosByName(String busqueda);
}
