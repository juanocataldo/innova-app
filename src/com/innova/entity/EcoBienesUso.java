package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_ECONOMATO.ECO_BIENES_USO")
public class EcoBienesUso {

	public EcoBienesUso() {
		
	}
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GEN_POR_BIEN_USO")
	@SequenceGenerator(name="GEN_POR_BIEN_USO", sequenceName="FPA_ECONOMATO.SEQ_ECO_BIENES_USO", allocationSize=1)
	@Column(name="BU_ID")
	private int id;
	
	@Column(name="BU_NOMBRE")
	private String nombre;
	
	@Column(name="BU_STOCK")
	private int stock;

	@Column(name="BU_ESTADO")
	private int estado;
	
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public EcoBienesUso(String nombre, int stock, int estado) {
		
		this.nombre = nombre;
		this.stock = stock;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "eco_bienes_uso [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", estado="+estado+"]";
	}
	
	
}
