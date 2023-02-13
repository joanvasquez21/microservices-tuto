package com.usuario.service.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.service.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario , Integer>{

}
