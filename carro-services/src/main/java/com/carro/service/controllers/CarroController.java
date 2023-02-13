package com.carro.service.controllers;

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

import com.carro.service.entidades.Carro;
import com.carro.service.services.CarroService;


@RestController
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	private CarroService carroService;
	
	@GetMapping
	public ResponseEntity<List<Carro>> listarUsuario(){
		List<Carro> usuarios = carroService.getAll();
		if(usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}	
		return ResponseEntity.ok(usuarios);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarro(@PathVariable("id") int id ){
		Carro carro = carroService.getCarroById(id);
		if(carro == null) {
			return ResponseEntity.notFound().build();
		}
			return ResponseEntity.ok(carro);
	}
	@PostMapping
	public ResponseEntity<Carro> guardarCarro(@RequestBody Carro carro){
		Carro  nuevoCarro =  carroService.save(carro);
		return ResponseEntity.ok(nuevoCarro);	
	}
	
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<Optional<Carro>> listarCarroPorId(@PathVariable("id") int id){
		Optional<Carro> carros = carroService.byUsuarioId(id);
		if(carros.isEmpty()) {
		   return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
}
