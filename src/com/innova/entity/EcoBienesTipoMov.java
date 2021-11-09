package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_ECONOMATO.ECO_BIENES_TIPO_MOV")
public class EcoBienesTipoMov {

	public EcoBienesTipoMov() {
		
	}
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GEN_POR_BIEN_TIPO_MOV")
	@SequenceGenerator(name="GEN_POR_BIEN_TIPO_MOV", sequenceName="FPA_PORTAL.SEQ_ECO_BIENES_TIPO_MOV", allocationSize=1)
	@Column(name="BTM_ID")
	private int id;
	
	@Column(name="BTM_MOV")
	private String movimiento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}

	public EcoBienesTipoMov(String movimiento) {
		super();
		this.movimiento = movimiento;
	}

	@Override
	public String toString() {
		return "eco_bienes_tipo_mov [id=" + id + ", movimiento=" + movimiento + "]";
	}
	
	
}
