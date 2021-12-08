package com.innova.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_ECONOMATO.ECO_BIENES_MOV")
public class EcoBienesMov {

	public EcoBienesMov() {
		
	}
	
	@ManyToOne()
	@JoinColumn(name="BM_PER_ID", insertable = false, updatable = false)
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@ManyToOne()
	@JoinColumn(name="BM_BU_ID", insertable = false, updatable = false)
	private EcoBienesUso bienUso;
	
	@ManyToOne()
	@JoinColumn(name="BM_BC_ID", insertable = false, updatable = false)
	private Economato_Elementos bienConsumo;
	
	@Id
	@Column(name="BM_ID")
	private int id;
	
	@Column(name="BM_BU_ID")
	private Integer bienBuId;
	
	@Column(name="BM_BTM_ID")
	private int tipoMovId;
	
	@Column(name="BM_DETALLE")
	private String detalle;
	
	@Column(name="BM_PER_ID")
	private int perId;
	
	@Column(name="BM_FECHA")
	private Date fecha;
	
	@Column(name="BM_BC_ID")
	private Integer bienBcId;

	@Column(name="BM_CANT")
	private Integer cant;
	
	@Column(name="BM_CARGO_TEMP")
	private Integer temp;
	
	
	
	public EcoBienesUso getBienUso() {
		return bienUso;
	}

	public void setBienUso(EcoBienesUso bienUso) {
		this.bienUso = bienUso;
	}

	public Economato_Elementos getBienConsumo() {
		return bienConsumo;
	}

	public void setBienConsumo(Economato_Elementos bienConsumo) {
		this.bienConsumo = bienConsumo;
	}

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	public Integer getCant() {
		return cant;
	}

	public void setCant(Integer cant) {
		this.cant = cant;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getBienBuId() {
		return bienBuId;
	}

	public void setBienBuId(Integer bienBuId) {
		this.bienBuId = bienBuId;
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

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getBienBcId() {
		return bienBcId;
	}

	public void setBienBcId(Integer bienBcId) {
		this.bienBcId = bienBcId;
	}

	public EcoBienesMov(Integer cant, Integer bienBuId, int tipoMovId, String detalle, int perId, Date fecha, Integer bienBcId, Integer temp) {
		super();
		this.bienBuId = bienBuId;
		this.tipoMovId = tipoMovId;
		this.detalle = detalle;
		this.perId = perId;
		this.fecha = fecha;
		this.bienBcId = bienBcId;
		this.cant = cant;
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "EcoBienesMov [id=" + id + ", bienBuId=" + bienBuId + ", tipoMovId=" + tipoMovId + ", detalle=" + detalle
				+ ", perId=" + perId + ", fecha=" + fecha + ", bienBcId=" + bienBcId + ", cant="+cant+"], temp="+temp+"]";
	}

	
	
}
