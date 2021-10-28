package com.innova.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;

import com.innova.entity.Persona;
import com.innova.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public List<Persona> getUsersByName(String search);

	public Persona getPersonaById(int id);

		
}
