package com.innova.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FPA_PORTAL.POR_INGRESO_LOG")
public class Ingreso {
	
	public Ingreso() {
		
	}
		
	@ManyToOne()
	@JoinColumn(name="PI_PER_ID", insertable = false, updatable = false)
	private Persona persona;
	

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GEN_POR_INGRESO")
	@SequenceGenerator(name="GEN_POR_INGRESO", sequenceName="FPA_PORTAL.SEQ_POR_INGRESO", allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PI_ID")
	private Integer id;
	
	@Column(name="PI_PER_ID")
	private Integer userId;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="dd-MM-YY HH:mm")
	@Column(name="PI_FECHA_HORA_INI")
	private Date fechaIn;
	
	@PrePersist
	private void onCreate() {
		Timestamp ts=new Timestamp(System.currentTimeMillis());  
		fechaIn = new Date(ts.getTime());
	}
	
	@Column(name="PI_FECHA_HORA_FIN")
	private Date fechaFin;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getFechaIn() {
		return fechaIn;
	}

	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
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

	public Ingreso(Integer userId, Date fechaIn, Date fechaFin, String userIns, String userUpd, String audIns,
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
