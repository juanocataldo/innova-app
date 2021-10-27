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
@Table(name="FPA_INVESTIGACIONES.INV_SUMARIOS")
public class Sumarios {

	@OneToOne
	@JoinColumn(name="SUM_ID")
	private SumAsigInv sumAsigInv;
	
	public Sumarios() {
		
	}
	
	
	public SumAsigInv getSumAsigInv() {
		return sumAsigInv;
	}

	public void setSumAsigInv(SumAsigInv sumAsigInv) {
		this.sumAsigInv = sumAsigInv;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUM_ID")
	private int id;
	
	@Column(name="SUM_NRO")
	private Integer digital;
	
	@Column(name="SUM_NRO_SAC")
	private Integer sac;
	
	@Column(name="SUM_ESPECIAL")
	private String especial;
	
	@Column(name="SUM_FISCALIA")
	private String fiscalia;
	
	@Column(name="SUM_LATITUD")
	private String latitud;
	
	@Column(name="SUM_LONGITUD")
	private String longitud;
	
	@Column(name="SUM_ORIGEN")
	private String origen;
	
	@Column(name="SUM_ESTADO")
	private String estado;

	public Sumarios(Integer digital, Integer sac, String especial, String fiscalia, String latitud, String longitud,
			String origen, String estado) {
		this.digital = digital;
		this.sac = sac;
		this.especial = especial;
		this.fiscalia = fiscalia;
		this.latitud = latitud;
		this.longitud = longitud;
		this.origen = origen;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getDigital() {
		return digital;
	}

	public void setDigital(Integer digital) {
		this.digital = digital;
	}

	public int getSac() {
		return sac;
	}

	public void setSac(Integer sac) {
		this.sac = sac;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}

	public String getFiscalia() {
		return fiscalia;
	}

	public void setFiscalia(String fiscalia) {
		this.fiscalia = fiscalia;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Sumarios [id=" + id + ", digital=" + digital + ", sac=" + sac + ", especial=" + especial + ", fiscalia="
				+ fiscalia + ", latitud=" + latitud + ", longitud=" + longitud + ", origen=" + origen + ", estado="
				+ estado + "]";
	}	
}
