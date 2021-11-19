package com.innova.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.PersonaDAO;
import com.innova.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaDAO personaDAO;
	
	@Transactional
	@Override
	public List<Persona> listPersonas() {
		
		List<Persona> listPersonas = personaDAO.listPersonas();
		return listPersonas;
	}

	@Transactional
	@Override
	public int countPersonas() {
		
		int cantidad = personaDAO.countPersonas();
		return cantidad;
	}

	@Transactional
	@Override
	public Persona getPersonaByNameOrDni(BigDecimal dni) {
		
		Persona getPersona = personaDAO.getPersonaByNombreOrDni(dni);
		return getPersona;
	}

	@Transactional
	@Override
	public int getIdByDni(Integer id) {
		int getPersona = personaDAO.getIdByDni(id);
		return getPersona;
	}
	
	@Transactional
	@Override
	public Persona getPersonById(int id) {
		Persona getPersona = personaDAO.getIdById(id);
		return getPersona;
	}

	

}
