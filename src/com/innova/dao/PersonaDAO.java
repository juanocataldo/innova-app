package com.innova.dao;

import java.math.BigDecimal;
import java.util.List;

import com.innova.entity.Persona;
import com.innova.entity.Personal;

public interface PersonaDAO {

	List<Persona> listPersonas();

	int countPersonas();

	Persona getPersonaByNombreOrDni(BigDecimal dni);

	int getIdByDni(Integer id);

	Persona getIdById(int id);

	Personal getPersonalByPersonaId(Integer id);
}
