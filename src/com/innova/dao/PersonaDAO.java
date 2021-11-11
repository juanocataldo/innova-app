package com.innova.dao;

import java.math.BigDecimal;
import java.util.List;

import com.innova.entity.Persona;

public interface PersonaDAO {

	List<Persona> listPersonas();

	int countPersonas();

	Persona getPersonaByNombreOrDni(BigDecimal dni);

	int getIdByDni(Integer id);
}
