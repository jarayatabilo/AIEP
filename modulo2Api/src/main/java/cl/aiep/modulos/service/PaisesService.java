package cl.aiep.modulos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.modulos.repository.PaisesRepository;
import cl.aiep.modulos.repository.entity.Paises;

@Service
public class PaisesService {

	@Autowired
	PaisesRepository repoPaises;
	
	
	public List <Paises> obtienePaises(){
		return repoPaises.findAll();
		
	}
	public Paises obtienePais(Integer id) {
		Optional<Paises> optional = repoPaises.findById(id);
		 Paises pais= new Paises();
		 if (optional.isPresent())
			 pais= optional.get();
		
		return pais;
	}
	
	public void agregarPais(Paises pais) {
		repoPaises.save(pais);
		
	}
	public void eliminarPais(Integer id) {

		repoPaises.deleteById(id);
		
	}
	public void modificarPais(Paises pais) {
		repoPaises.save(pais);
		
	}
	
}
