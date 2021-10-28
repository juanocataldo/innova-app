package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_PORTAL.POR_INGRESO")
public class Ingreso {
	
	public Ingreso() {
		
	}
	
	@Id
	//@SequenceGenerator(name="GEN_POR_INGRESO", sequenceName="FPA_PORTAL.SEQ_POR_INGRESO")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GEN_POR_INGRESO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PI_ID")
	private int id;
	
	@Column(name="PI_USER_ID")
	private int userId;
	
	@Column(name="PI_FECHA_HORA_INI")
	private String fechaIn;
	
	@Column(name="PI_FECHA_HORA_FIN")
	private String fechaFin;
	
	@Column(name="AUD_USR_INS")
	private String userIns;
	
	@Column(name="AUD_USR_UPD")
	private String userUpd;
	
	@Column(name="AUD_FECHA_INS")
	private String audIns;
	
	@Column(name="AUD_FECHA_UPD")
	private String audUpd;
	
	@Column(name="AUD_FECHA_DEL")
	private String audDel;
	
	@Column(name="PI_DETALLES")
	private String detalles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFechaIn() {
		return fechaIn;
	}

	public void setFechaIn(String fechaIn) {
		this.fechaIn = fechaIn;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getUserIns() {
		return userIns;
	}

	public void setUserIns(String userIns) {
		this.userIns = userIns;
	}

	public String getUserUpd() {
		return userUpd;
	}

	public void setUserUpd(String userUpd) {
		this.userUpd = userUpd;
	}

	public String getAudIns() {
		return audIns;
	}

	public void setAudIns(String audIns) {
		this.audIns = audIns;
	}

	public String getAudUpd() {
		return audUpd;
	}

	public void setAudUpd(String audUpd) {
		this.audUpd = audUpd;
	}

	public String getAudDel() {
		return audDel;
	}

	public void setAudDel(String audDel) {
		this.audDel = audDel;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public Ingreso(int userId, String fechaIn, String fechaFin, String userIns, String userUpd, String audIns,
			String audUpd, String audDel, String detalles) {
		super();
		this.userId = userId;
		this.fechaIn = fechaIn;
		this.fechaFin = fechaFin;
		this.userIns = userIns;
		this.userUpd = userUpd;
		this.audIns = audIns;
		this.audUpd = audUpd;
		this.audDel = audDel;
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Ingreso [id=" + id + ", userId=" + userId + ", fechaIn=" + fechaIn + ", fechaFin=" + fechaFin
				+ ", userIns=" + userIns + ", userUpd=" + userUpd + ", audIns=" + audIns + ", audUpd=" + audUpd
				+ ", audDel=" + audDel + ", detalles=" + detalles + "]";
	}
	
	

}
