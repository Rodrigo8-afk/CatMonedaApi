package com.mx.catModenaApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.mx.catModenaApi.entity.CatMoneda;

public interface ICatMonedaRepository extends JpaRepository<CatMoneda, Integer>{

	@Query(nativeQuery = true,
			value = "SELECT NUM_CIA"
					+ " FROM HU_CAT_MONEDA"
					+ " WHERE UPPER(ESTATUS)= UPPER('A')")
	public List<Integer> findByEstatus();
	
}
