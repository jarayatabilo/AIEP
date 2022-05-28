package cl.aiep.modulos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.modulos.repository.entity.Paises;
import cl.aiep.modulos.service.PaisesService;

@RestController
@RequestMapping("/api/v1/paises")
public class RestFulApiControllerPais {
	
	@Autowired
	PaisesService service;
	
	@GetMapping ("/listartodos")
	public List<Paises> obtienePaises(){
		return service.obtienePaises();
	}
	
	@GetMapping("/mostrarpor/{id}")
	public Paises obtener(@PathVariable Integer id) {
		
		return service.obtienePais(id);
	}
	
	@PutMapping ("/agregar")
	public String agregarPais(@RequestBody Paises pais) {
		
		service.agregarPais(pais);
		return "Pais Insertado Correctamente";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarPais(@PathVariable Integer id) {
		
		service.eliminarPais(id);
		return "Pais Eliminado Correctamente";
	}
	
	@PatchMapping ("/modificar")
	public String modificarPais(@RequestBody Paises pais) {
		service.modificarPais(pais);
		return "Pais modificado Correctamente";
	}
	

}
