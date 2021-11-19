package com.innova.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.innova.entity.Persona;
import com.innova.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public List<Persona> getUsersByName(String search);

	public Persona getPersonaById(int id);

	public User getUserById(int id);

	public List<Persona> getUserByName(String personaSearch);

	public Persona getOneUserByName(String search);

	public List<Persona> listPersonasByDni(BigDecimal dni);

	public Persona getPersonaByDni(BigDecimal dni);
}
