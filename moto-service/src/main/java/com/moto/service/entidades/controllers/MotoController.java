package com.moto.service.entidades.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidades.Moto;
import com.moto.service.services.MotoServices;

@RestController
@RequestMapping("/moto")
public class MotoController {

	@Autowired
	private MotoServices motoService;
	
	@GetMapping
	public ResponseEntity<List<Moto>> listarUsuario(){
		List<Moto> usuarios = motoService.getAll();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}	
		return ResponseEntity.ok(usuarios);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerCarro(@PathVariable("id") int id ){
		Moto carro = motoService.getCarroById(id);
		if(carro == null) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(carro);
	}
	@PostMapping
	public ResponseEntity<Moto> guardarMoto(@RequestBody Moto carro){
		Moto  nuevoCarro =  motoService.save(carro);
		return ResponseEntity.ok(nuevoCarro);	
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<Optional<Moto>> listarMotoPorId(@PathVariable("id") int id){
		Optional<Moto> motos = motoService.byUsuarioId(id);
		if(motos.isEmpty()) {
		   return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
	}
	
}
