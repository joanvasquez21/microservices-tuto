package com.carro.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carro.service.entidades.Carro;
import com.carro.service.repository.CarroRepository;


@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> getAll(){
		return carroRepository.findAll();
	}
	
	public Carro getCarroById(int id) {
		return carroRepository.findById(id).orElse(null);
	}
	public Carro save(Carro carro) {
		return carroRepository.save(carro);
	}
	
	public Optional<Carro> byUsuarioId(int usuarioId){
		return carroRepository.findById(usuarioId);
	}
	
	
}
