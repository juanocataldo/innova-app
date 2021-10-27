package com.innova.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FPA_INVESTIGACIONES.INV_SUMARIOS_ASIG_INVESTIGADOR")
public class SumAsigInv {
	
	@OneToOne(mappedBy="sumAsigInv")	
	private Sumarios sum;
	
	@OneToOne(mappedBy="sumAsigInv")
	private Persona persona;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SAI_ID")
	private int id;
	
	@Column(name="SAI_PER_ID")
	private int perid;
	
	@Column(name="SAI_SUM_ID")
	private int sumid;
	
		
	public int getSumid() {
		return sumid;
	}

	public void setSumid(int sumid) {
		this.sumid = sumid;
	}

	public Sumarios getSum() {
		return sum;
	}

	public void setSum(Sumarios sum) {
		this.sum = sum;
	}

	public SumAsigInv() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPerid() {
		return perid;
	}

	public void setPerid(int perid) {
		this.perid = perid;
	}

	public SumAsigInv(Sumarios sum, int perid, int sumid) {		
		this.sum = sum;
		this.perid = perid;
		this.sumid = sumid;
	}

	@Override
	public String toString() {
		return "SumAsigInv [sum=" + sum + ", id=" + id + ", perid=" + perid + ", sumid=" + sumid + "]";
	}	
}
