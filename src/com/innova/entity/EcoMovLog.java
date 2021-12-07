package com.innova.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_ECONOMATO.ECO_BIENES_MOV_LOG")
public class EcoMovLog {

	public EcoMovLog() {
		
	}
	
	@Id
	@Column(name="BML_ID")
	private int id;
	
	@Column(name="BML_BM_ID")
	private int idMov;
	
	@Column(name="BML_FECHA")
	private Date fecha;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdMov() {
		return idMov;
	}

	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EcoMovLog(int idMov, Date fecha) {
		super();
		this.idMov = idMov;
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "EcoMovLog [id=" + id + ", idMov=" + idMov + ", fecha=" + fecha + "]";
	}
	
	
	
}
