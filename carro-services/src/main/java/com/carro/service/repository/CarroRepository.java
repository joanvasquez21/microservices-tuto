package com.carro.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carro.service.entidades.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

	
	
}
