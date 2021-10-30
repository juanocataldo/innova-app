package com.innova.service;

import java.util.List;

import com.innova.entity.Ingreso;
import com.innova.entity.Persona;
import com.innova.entity.User;

public interface UserService {

	List<User> listUsers();

	List<Persona> listUsersByName(String search);
	
	Persona getPersonaById(int id);
	
	void ingresoPersona(Ingreso ingreso);

	User getUserById(int id);
	
	List<Ingreso> getPersonasIncome(String search);

	List<Persona> getPersonaByName(String personaSearch);
}
