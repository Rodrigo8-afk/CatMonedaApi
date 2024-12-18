package com.mx.catModenaApi.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name = "HU_CAT_MONEDA")
public class CatMoneda {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "NUM_CIA")
	private int numCia;
	@Column(name= "CLAVE_MONEDA")
	private String claveMoneda;
	private String descripcion;
	private String simbolo;
	private String abreviacion;
	@Column(name="MONEDA_CORRIENTE")
	private String monedaCorriente;
	private String estatus;
	
	
	public CatMoneda() {
	}


	public CatMoneda(int numCia, String claveMoneda, String descripcion, String simbolo, String abreviacion,
			String monedaCorriente, String status) {
		this.numCia = numCia;
		this.claveMoneda = claveMoneda;
		this.descripcion = descripcion;
		this.simbolo = simbolo;
		this.abreviacion = abreviacion;
		this.monedaCorriente = monedaCorriente;
		this.estatus = status;
	}


	public int getNumCia() {
		return numCia;
	}


	public void setNumCia(int numCia) {
		this.numCia = numCia;
	}


	public String getClaveMoneda() {
		return claveMoneda;
	}


	public void setClaveMoneda(String claveMoneda) {
		this.claveMoneda = claveMoneda;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getSimbolo() {
		return simbolo;
	}


	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}


	public String getAbreviacion() {
		return abreviacion;
	}


	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}


	public String getMonedaCorriente() {
		return monedaCorriente;
	}


	public void setMonedaCorriente(String monedaCorriente) {
		this.monedaCorriente = monedaCorriente;
	}


	public String getStatus() {
		return estatus;
	}


	public void setStatus(String status) {
		this.estatus = status;
	}
	

	
}
