package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FPA_ECONOMATO.ECO_ELEMENTOS")
public class Economato_Elementos {

	/*
	@OneToOne(mappedBy="")
	private Economato_TipoElem tipoElem;
	*/
	
	public Economato_Elementos() {
		
	}
	
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "GEN_ELEMENTOS")
	@SequenceGenerator(name="GEN_ELEMENTOS", sequenceName="FPA_ECONOMATO.SEQ_ECO_ELEMENTOS", allocationSize=1)
	@Column(name="ELEM_ID")
	private int id;
	
	@Column(name="ELEM_NOMBRE")
	private String nombre;
	
	@Column(name="ELEM_TIPO_ID")
	private Integer tipo;
	
	@Column(name="ELEM_ESTADO")
	private Integer estado;

	@Column(name="ELEM_STOCK")
	private int stock;
	
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Economato_Elementos(String nombre, Integer tipo, Integer estado, int stock) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.estado = estado;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Economato_Elementos [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", estado=" + estado + ", stock="+ stock +"]";
	}	
}
