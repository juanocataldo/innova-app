package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_PORTAL.POR_INGRESO_ESTADO")
public class IngresoEstado {

	@ManyToOne()
	@JoinColumn(name="PIE_PER_ID", insertable = false, updatable = false)
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Id
	@Column(name="pie_per_id")
	private int perId;
	
	@Column(name="pie_estado")
	private int estado;

	public IngresoEstado() {
		
	}
	
	

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public IngresoEstado(int perId, int estado) {
		super();
		this.perId = perId;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "IngresoEstado [perId=" + perId + ", estado=" + estado + "]";
	}
	
	
}
