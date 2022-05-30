package cl.aiep.modulos.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.aiep.modulos.dao.IPaisesDAO;
import cl.aiep.modulos.dao.repository.PaisesRepository;
import cl.aiep.modulos.dao.repository.entity.Paises;
import cl.aiep.modulos.dto.PaisDTO;

@Repository
public class PaisesDAOImpl implements IPaisesDAO{
	@Autowired
	PaisesRepository repositorio;
	@Override
	public List<PaisDTO> obtenerPaises() {
		  List<PaisDTO> paises= new ArrayList<PaisDTO>();
		  for(Paises pais:repositorio.findAll())
			  		paises.add(new PaisDTO(pais.getId(),pais.getName()));
		return paises;
	}
	@Override
	public PaisDTO obtenerId(Integer id) {
		Optional<Paises> optional = repositorio.findById(id);
		Paises pais= optional.isPresent()?optional.get():new Paises();
		return new PaisDTO(pais.getId(), pais.getName());
	}
	@Override
	public void guardar(PaisDTO pais) {
		repositorio.save(new Paises(pais.getName()));
	}
	@Override
	public void eliminar(Integer id) {
		repositorio.deleteById(id);
	}
	@Override
	public void modificar(PaisDTO pais) {
		repositorio.save(new Paises(pais.getId(),pais.getName()));
	}
	@Override
	public List<PaisDTO> obtieneporLetra(String letra) {
		 List<PaisDTO> paises= new ArrayList<PaisDTO>();
		  for(Paises pais:repositorio.findByNameStartingWith(letra))
			  		paises.add(new PaisDTO(pais.getId(),pais.getName()));
		return paises;
	}
}
