package com.mx.catModenaApi.service;

import java.util.List;

import com.mx.catModenaApi.entity.CatMoneda;

public interface ICatMonedaService {
	
	public List<CatMoneda> findAll();
	
	public CatMoneda findById(int numCia);
	
	public CatMoneda save(CatMoneda catMoneda);
	
	public void delete(int numCia);
	
	public List<Integer> buscarPorEstatus();
	
}
