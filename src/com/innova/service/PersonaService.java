package com.innova.service;

import java.math.BigDecimal;
import java.util.List;

import com.innova.entity.Persona;
import com.innova.entity.Personal;

public interface PersonaService {

	List<Persona> listPersonas();

	int countPersonas();

	Persona getPersonaByNameOrDni(BigDecimal dni);

	int getIdByDni(Integer id);

	Persona getPersonById(int id);

	Personal getPersonalByPersonaId(Integer id);
	
	
}
