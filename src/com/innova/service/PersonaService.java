package com.innova.service;

import java.math.BigDecimal;
import java.util.List;

import com.innova.entity.Persona;

public interface PersonaService {

	List<Persona> listPersonas();

	int countPersonas();

	Persona getPersonaByNameOrDni(BigDecimal dni);
}
