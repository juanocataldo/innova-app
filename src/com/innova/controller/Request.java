package com.innova.controller;

import com.google.gson.JsonElement;

public class Request {

	 private String dni;
	 private JsonElement table;
	 private int tipoMov;
	 private Integer cant;
	 
	 
	 
	 
	 public int getCant() {
		return cant;
	}
	public void setCant(Integer cant) {
		this.cant = cant;
	}
	public int getTipoMov() {
		return tipoMov;
	}
	public void setTipoMov(int tipoMov) {
		this.tipoMov = tipoMov;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public JsonElement getTable() {
		return table;
	}
	public void setTable(JsonElement table) {
		this.table = table;
	}

	 
}
