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
@Table(name="FPA_ECONOMATO.ECO_TEMPORAL")
public class EcoTemporal {

	public EcoTemporal() {
		
	}
	
	@ManyToOne()
	@JoinColumn(name="ET_BU_ID", insertable = false, updatable = false)
	private EcoBienesUso bienUso;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GEN_TEMPORAL")
	@SequenceGenerator(name="GEN_TEMPORAL", sequenceName="FPA_ECONOMATO.SEQ_ECO_TEMPORAL", allocationSize=1)
	@Column(name="ET_ID")
	private int id;

	@Column(name="ET_PER_ID")
	private int perId;
	
	@Column(name="ET_BU_ID")
	private int buId;
	
	@Column(name="ET_CANT")
	private int cant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPerid() {
		return perId;
	}

	public void setPerid(int perid) {
		this.perId = perid;
	}

	public int getBuId() {
		return buId;
	}

	public void setBuId(int buId) {
		this.buId = buId;
	}

	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public EcoTemporal(int perId, int buId, int cant) {
		super();
		this.perId = perId;
		this.buId = buId;
		this.cant = cant;
	}

	@Override
	public String toString() {
		return "EcoTemporal [id=" + id + ", perId=" + perId + ", buId=" + buId + ", cant=" + cant + "]";
	}
	
	

}
