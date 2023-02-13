package com.moto.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moto.service.entidades.Moto;
import com.moto.service.repository.MotoRepository;

@Service
public class MotoServices {
	@Autowired
	private MotoRepository motoRepository;
	
	public List<Moto> getAll(){
		return motoRepository.findAll();
	}
	
	public Moto getCarroById(int id) {
		return motoRepository.findById(id).orElse(null);
	}
	public Moto save(Moto moto) {
		return motoRepository.save(moto);
	}
	
	public Optional<Moto> byUsuarioId(int usuarioId){
		return motoRepository.findById(usuarioId);
	}
}
