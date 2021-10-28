package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="FPA_PORTAL.POR_USUARIOS")
public class User {
	
	public User() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int id;
	
	@Column(name="USER_USERNAME")
	private String userName;
	
	@Column(name="USER_PER_ID")
	private int perid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPerid() {
		return perid;
	}

	public void setPerid(int perid) {
		this.perid = perid;
	}

	public User(String userName, int perid) {		
		this.userName = userName;
		this.perid = perid;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", perid=" + perid + "]";
	}

	
}
