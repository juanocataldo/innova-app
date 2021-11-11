package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_ECONOMATO.ECO_BIENES_MOV")
public class EcoBienesMov {

	public EcoBienesMov() {
		
	}
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GEN_POR_BIEN_MOV")
	@SequenceGenerator(name="GEN_POR_BIEN_MOV", sequenceName="FPA_ECONOMATO.SEQ_ECO_BIENES_MOV", allocationSize=1)
	@Column(name="BM_ID")
	private int id;
	
	@Column(name="BM_BU_ID")
	private int bienId;
	
	@Column(name="BM_BTM_ID")
	private int tipoMovId;
	
	@Column(name="BM_DETALLE")
	private String detalle;
	
	@Column(name="BM_PER_ID")
	private int perId;

	
	
	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBienId() {
		return bienId;
	}

	public void setBienId(int bienId) {
		this.bienId = bienId;
	}

	public int getTipoMovId() {
		return tipoMovId;
	}

	public void setTipoMovId(int tipoMovId) {
		this.tipoMovId = tipoMovId;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public EcoBienesMov(int bienId, int tipoMovId, String detalle, int perId) {
		super();
		this.bienId = bienId;
		this.tipoMovId = tipoMovId;
		this.detalle = detalle;
		this.perId = perId;
	}

	@Override
	public String toString() {
		return "eco_bienes_mov [id=" + id + ", bienId=" + bienId + ", tipoMovId=" + tipoMovId + ", detalle=" + detalle
				+ "], perId=" + perId +"]";
	}
	
	
}
