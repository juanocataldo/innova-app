package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FPA_RECURSOS_HUMANOS.RH_PERSONAL")
public class Personal {

	public Personal() {
		
	}
	
	/*
	@OneToOne
	@JoinColumn(name="PERSONAL_ID")
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
*/
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PERSONAL_ID")
	private int id;
	
	@Column(name="PERSONAL_NRO_PLACA")
	private Integer placa;
	
	@Column(name="PERSONAL_GRADO")
	private String grado;
	
	@Column(name="PERSONAL_CARGO")
	private String cargo;
	
	@Column(name="PERSONAL_ESTADO")
	private String estado;
	
	@Column(name="PERSONAL_REVISTA")
	private String revista;
	
	@Column(name="PERSONAL_LUGAR")
	private String lugar;
	
	@Column(name="PERSONAL_SECTOR")
	private String sector;
	
	@Column(name="PERSONAL_DIR_GRAL")
	private String dirGral;
	
	@Column(name="PERSONAL_COMPA_BRIGA")
	private String brigada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getPlaca() {
		return placa;
	}

	public void setPlaca(Integer placa) {
		this.placa = placa;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRevista() {
		return revista;
	}

	public void setRevista(String revista) {
		this.revista = revista;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getDirGral() {
		return dirGral;
	}

	public void setDirGral(String dirGral) {
		this.dirGral = dirGral;
	}

	public String getBrigada() {
		return brigada;
	}

	public void setBrigada(String brigada) {
		this.brigada = brigada;
	}

	public Personal(Integer placa, String grado, String cargo, String estado, String revista, String lugar, String sector,
			String dirGral, String brigada) {
		
		this.placa = placa;
		this.grado = grado;
		this.cargo = cargo;
		this.estado = estado;
		this.revista = revista;
		this.lugar = lugar;
		this.sector = sector;
		this.dirGral = dirGral;
		this.brigada = brigada;
	}

	@Override
	public String toString() {
		return "Personal [id=" + id + ", placa=" + placa + ", grado=" + grado + ", cargo=" + cargo + ", estado="
				+ estado + ", revista=" + revista + ", lugar=" + lugar + ", sector=" + sector + ", dirGral=" + dirGral
				+ ", brigada=" + brigada + "]";
	}
	
	
}
