package com.innova.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innova.dao.IngresoDAO;
import com.innova.dao.UserDAO;
import com.innova.entity.Ingreso;
import com.innova.entity.IngresoEstado;
import com.innova.entity.Persona;
import com.innova.entity.User;


@Service
public class UserServiceImpl implements UserService {

@Autowired
UserDAO userDAO;

@Autowired
IngresoDAO ingresoDAO;

	@Transactional
	@Override
	public List<User> listUsers() {

		List<User> listUsers = userDAO.getUsers();
		
		return listUsers;
		
	}

	@Transactional
	@Override
	public List<Persona> listUsersByName(String search) {
		
		List<Persona> listUsers = userDAO.getUsersByName(search);
		
		return listUsers;
	}

	@Transactional
	@Override
	public Persona getPersonaById(int id) {
		
		Persona persona = userDAO.getPersonaById(id);
		
		return persona;
	}

	@Transactional
	@Override
	public void ingresoPersona(Ingreso ingreso) {
		System.out.println("PERSONA EN SERVICE IMPL "+ingreso);
		ingresoDAO.ingresoPersona(ingreso);		
	}

	@Transactional
	@Override
	public User getUserById(int id) {
	
		User user = userDAO.getUserById(id);
		
		return user;
	}

	@Transactional
	@Override
	public List<Ingreso> getPersonasIncome(String search) {
		
		List<Ingreso> ingresos = ingresoDAO.getIngresosPersonas(search); 
		return ingresos;
	}

	@Transactional
	@Override
	public List<Persona> getPersonaByName(String personaSearch) {
		
		List<Persona> personas = userDAO.getUserByName(personaSearch);
		return personas;
	}

	@Transactional
	@Override
	public Persona getPersonaFiltro(String palabra) {
		
		return null;
	}

	@Transactional
	@Override
	public Persona getOnePersonaByName(String search) {

		Persona persona = userDAO.getOneUserByName(search);
		return persona;
	}

	@Transactional
	@Override
	public void estadoIngreso(IngresoEstado ingresoEstado) {
		
		ingresoDAO.saveIngresoEstado(ingresoEstado);
		
	}

	@Transactional
	@Override
	public List<Persona> listUsersByDni(BigDecimal dni) {
		
		List<Persona> personas = userDAO.listPersonasByDni(dni);
		
		return personas;
	}
	
	
	

}
