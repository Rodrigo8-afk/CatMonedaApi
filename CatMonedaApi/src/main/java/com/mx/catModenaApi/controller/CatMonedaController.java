package com.mx.catModenaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mx.catModenaApi.service.ICatMonedaService;

@RestController
@RequestMapping(path = "/v1/api/catMoneda")
@CrossOrigin("*")
public class CatMonedaController {
	
	@Autowired
	private ICatMonedaService catMonedaService;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<CatMoneda> listado = catMonedaService.findAll();
		
		if(listado.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(listado);
	}
	
	@GetMapping("/{idCatMoneda}")
	public ResponseEntity<?> buscarPorId(@PathVariable int idCatMoneda){
		CatMoneda catMoneda = catMonedaService.findById(idCatMoneda);
		
		if(catMoneda == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(catMoneda);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody CatMoneda catMoneda){
		CatMoneda catMonedaNueva = catMonedaService.save(catMoneda);
		
		return ResponseEntity.status(HttpStatus.OK).body(catMonedaNueva);
	}
	
	@PutMapping("/{idCatMoneda}")
	public ResponseEntity<?> editar(@PathVariable int idCatMoneda, @RequestBody CatMoneda catMoneda){
		CatMoneda catMonedaEditar = catMonedaService.findById(idCatMoneda);
		
		if(catMonedaEditar != null) {
			catMonedaEditar.setClaveMoneda(catMoneda.getClaveMoneda());
			catMonedaEditar.setDescripcion(catMoneda.getDescripcion());
			catMonedaEditar.setSimbolo(catMoneda.getSimbolo());
			catMonedaEditar.setAbreviacion(catMoneda.getAbreviacion());
			catMonedaEditar.setMonedaCorriente(catMoneda.getMonedaCorriente());
			catMonedaEditar.setStatus(catMoneda.getStatus());
			
			catMonedaService.save(catMonedaEditar);
			return ResponseEntity.status(HttpStatus.OK).body(catMonedaEditar);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{idCatMoneda}")
	public ResponseEntity<?> eliminar(@PathVariable int idCatMoneda){
		CatMoneda catMonedaEliminar = catMonedaService.findById(idCatMoneda);
		
		if(catMonedaEliminar == null) {
			return ResponseEntity.notFound().build();
		}else {
			catMonedaService.delete(idCatMoneda);
			return ResponseEntity.status(HttpStatus.OK).body(catMonedaEliminar);
		}
			
		
	}
	
}
