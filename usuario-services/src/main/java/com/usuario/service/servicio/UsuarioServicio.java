package com.usuario.service.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.feignclients.CarroFeignClient;
import com.usuario.service.feignclients.MotoFeignClient;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.repositorios.UsuarioRepository;

@Service
public class UsuarioServicio {
	
	@Autowired
	private RestTemplate  restTemplate;
	
	@Autowired
	private CarroFeignClient carroFeignclient;
	
	@Autowired
	private MotoFeignClient motoFeignClient;
	
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	// RestTemplate
	public List<Carro> getCarros(int usuarioId){
		List<Carro> carros = restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId, List.class);
		return carros; 
	}

	//RestTemplate
	public List<Moto> getMotos(int usuarioId){
		List<Moto> motos = restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId, List.class);
		return motos; 
	}
	
	
	//Feig client
	public Carro  saveCarro(int usuarioId, Carro carro) {
		carro.setUsuarioId(usuarioId);
		Carro nuevoCarro = carroFeignclient.save(carro);
		return nuevoCarro;
	}
	
	//Feig client
	public Moto  saveMoto(int usuarioId, Moto moto) {
		moto.setUsuarioId(usuarioId);
		Moto nuevaMoto = motoFeignClient.save(moto);
		return nuevaMoto;
	}
	
	//Implementar metodo para tener getusuario y vehiculos
	public Map<String, Object> getUsuarioAndVehiculos(int usuarioId){
		Map<String, Object> resultado = new HashMap<>();
		Usuario usuario = usuarioRepositorio.findById(usuarioId).orElse(null);
		if(usuario == null) {
			resultado.put("Mensaje", "El usuario no existe");		
			return resultado;
		}
		resultado.put("Usuario", usuario);
		
		//Lista de carros
		List<Carro> carros = carroFeignclient.getCarro(usuarioId);
		
		if(carros.isEmpty()) {
			resultado.put("Carros", "el usuario no tiene carros");
		}else {
			resultado.put("Carros", carros);
		}
		
		List<Moto> motos = motoFeignClient.getMotos(usuarioId);
		if(motos.isEmpty()) {
			resultado.put("Motos", "El usuario no tiene motos");
		}else {
			resultado.put("Motos", motos);
		}
		return resultado;
	}

	public List<Usuario> getAll(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario getUsuarioById(int id) {
		return usuarioRepositorio.findById(id).orElse(null);
	}
	public Usuario save(Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	
	
	
}
