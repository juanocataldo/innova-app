package com.innova.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FPA_RECURSOS_HUMANOS.RH_PERSONAS")
public class Persona {
	
	@OneToOne()
	@JoinColumn(name="PER_ID")
	private SumAsigInv sumAsigInv;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID")
	private Integer id;
	
	@Column(name="PER_NOMBRE")
	private String nombre;
	
	@Column(name="PER_APELLIDO")	
	private String apellido;
	
	
	@Column(name="PER_DNI")
	private BigDecimal dni;
	
	@Column(name="PER_FECHA_BAJA")
	private String fechaBaja;
	
	@Column(name="PER_SEXO")
	private String sexo;
	
	@Column(name="PER_FECHA_NAC")
	private String fechaNac;
	
	@Column(name="AUD_USR_INS")
	private String usrIns;
	
	@Column(name="AUD_USR_UPD")
	private String usrUpd;
	
	@Column(name="AUD_FECHA_INS")
	private String fechaIns;
	
	@Column(name="AUD_FECHA_UPD")
	private String fechaUpd;
	
	@Column(name="PERSONAL_ID")
	private Integer personalId;
	
	public Persona() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public BigDecimal getDni() {
		return dni;
	}

	public void setDni(BigDecimal dni) {
		this.dni = dni;
	}

	public String getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getUsrIns() {
		return usrIns;
	}

	public void setUsrIns(String usrIns) {
		this.usrIns = usrIns;
	}

	public String getUsrUpd() {
		return usrUpd;
	}

	public void setUsrUpd(String usrUpd) {
		this.usrUpd = usrUpd;
	}

	public String getFechaIns() {
		return fechaIns;
	}

	public void setFechaIns(String fechaIns) {
		this.fechaIns = fechaIns;
	}

	public String getFechaUpd() {
		return fechaUpd;
	}

	public void setFechaUpd(String fechaUpd) {
		this.fechaUpd = fechaUpd;
	}

	public Integer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}

	public Persona(String nombre, String apellido, BigDecimal dni, String fechaBaja, String sexo, String fechaNac,
			String usrIns, String usrUpd, String fechaIns, String fechaUpd, int personalId) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaBaja = fechaBaja;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
		this.usrIns = usrIns;
		this.usrUpd = usrUpd;
		this.fechaIns = fechaIns;
		this.fechaUpd = fechaUpd;
		this.personalId = personalId;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", fechaBaja="
				+ fechaBaja + ", sexo=" + sexo + ", fechaNac=" + fechaNac + ", usrIns=" + usrIns + ", usrUpd=" + usrUpd
				+ ", fechaIns=" + fechaIns + ", fechaUpd=" + fechaUpd + ", personalId=" + personalId + "]";
	}

	
	
	
}
