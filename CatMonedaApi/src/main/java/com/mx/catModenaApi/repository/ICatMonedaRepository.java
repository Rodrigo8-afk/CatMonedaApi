package com.mx.catModenaApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.catModenaApi.entity.CatMoneda;

public interface ICatMonedaRepository extends JpaRepository<CatMoneda, Integer>{

	@Query(nativeQuery = true,
			value = "SELECT *"
					+ " FROM HU_CAT_MONEDA"
					+ " WHERE UPPER(ESTATUS)= UPPER(:estatus)")
	public List<CatMoneda> findByEstatus(@Param ("estatus") String estatus);
	
	@Query(nativeQuery = true,
			value = "SELECT MAX(NUM_CIA) FROM HU_CAT_MONEDA")
	public int  obtenerMax();
	
	

}
