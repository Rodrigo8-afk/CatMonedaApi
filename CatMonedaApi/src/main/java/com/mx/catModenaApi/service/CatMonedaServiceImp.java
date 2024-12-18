package com.mx.catModenaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.catModenaApi.entity.CatMoneda;
import com.mx.catModenaApi.repository.ICatMonedaRepository;

@Service
public class CatMonedaServiceImp implements ICatMonedaService{

	@Autowired 
	private ICatMonedaRepository catMonedaRepository;
	
	@Override
	public List<CatMoneda> findAll() {
		return catMonedaRepository.findAll();
	}

	@Override
	public CatMoneda findById(int numCia) {
		return catMonedaRepository.findById(numCia).orElse(null);
	}

	@Override
	public CatMoneda save(CatMoneda catMoneda) {
		return catMonedaRepository.save(catMoneda);
	}

	@Override
	public void delete(int numCia) {
		catMonedaRepository.deleteById(numCia);
	}
	
	@Override
	public List<CatMoneda> buscarPorEstatus(String estatus){
		return catMonedaRepository.findByEstatus(estatus);
	}
	
	public int obtenerMaxNumCia() {
		return catMonedaRepository.obtenerMax();
	}
	
}
