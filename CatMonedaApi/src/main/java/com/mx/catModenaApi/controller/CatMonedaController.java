package com.mx.catModenaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.catModenaApi.entity.CatMoneda;
import com.mx.catModenaApi.service.CatMonedaServiceImp;


@RestController
@RequestMapping(path = "/v1/api/catMoneda")
@CrossOrigin("*")
public class CatMonedaController {
	
	@Autowired
	private CatMonedaServiceImp catMonedaService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<CatMoneda> listado = catMonedaService.findAll();
		
		if(listado.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(listado);
	}
	
	@GetMapping("/{numCia}")
	public ResponseEntity<?> buscarPorNumCia(@PathVariable int numCia){
		CatMoneda catMoneda = catMonedaService.findById(numCia);
		if(catMoneda == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(catMoneda);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody CatMoneda catMoneda){
		
		if(catMoneda.getNumCia() >= catMonedaService.obtenerMaxNumCia()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}else {
			CatMoneda catMonedaexiste = catMonedaService.findById(catMoneda.getNumCia());
			
			if(catMonedaexiste != null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}else {
				CatMoneda catMonedaNueva = catMonedaService.save(catMoneda);
				return ResponseEntity.status(HttpStatus.OK).body(catMonedaNueva);
			}
		}
		
	}
	
	
	@PutMapping("/{numCia}")
	public ResponseEntity<?> editar(@PathVariable int numCia, @RequestBody CatMoneda catMoneda){
		CatMoneda catMonedaEditar = catMonedaService.findById(numCia);
		
		if(catMonedaEditar != null) {
			catMonedaEditar.setClaveMoneda(catMoneda.getClaveMoneda());
			catMonedaEditar.setDescripcion(catMoneda.getDescripcion());
			catMonedaEditar.setSimbolo(catMoneda.getSimbolo());
			catMonedaEditar.setAbreviacion(catMoneda.getAbreviacion());
			catMonedaEditar.setMonedaCorriente(catMoneda.getMonedaCorriente());
			catMonedaEditar.setEstatus(catMoneda.getEstatus());
			
			catMonedaService.save(catMonedaEditar);
			return ResponseEntity.status(HttpStatus.OK).body(catMonedaEditar);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{numCia}")
	public ResponseEntity<?> eliminar(@PathVariable int numCia){
		CatMoneda catMonedaEliminar = catMonedaService.findById(numCia);
		
		if(catMonedaEliminar == null) {
			return ResponseEntity.notFound().build();
		}else {
			catMonedaService.delete(numCia);
			return ResponseEntity.status(HttpStatus.OK).body(catMonedaEliminar);
		}
			
		
	}
	
	@GetMapping("/buscarEstatus")
	public ResponseEntity<?> buscarPorEstatus(@Param("estatus") String estatus){
		List<CatMoneda> listado = catMonedaService.buscarPorEstatus(estatus);
		
		return ResponseEntity.status(HttpStatus.OK).body(listado);
	}
	
	
}
