package cl.aiep.modulos.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.modulos.dao.PaisesDAO;
import cl.aiep.modulos.repository.PaisesRepository;
import cl.aiep.modulos.repository.RegionesRepository;
import cl.aiep.modulos.repository.dto.PaisesDTO;
import cl.aiep.modulos.repository.dto.PaisesRegionesDTO;
import cl.aiep.modulos.repository.dto.RegionDTO;
import cl.aiep.modulos.repository.entity.Paises;
import cl.aiep.modulos.repository.entity.Regiones;

@Repository
public class PaisesDAOImpl implements PaisesDAO{

	@Autowired
	PaisesRepository repoPaises;
	@Autowired
	RegionesRepository repoRegiones;
	
	@Autowired
	JdbcTemplate template;
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<PaisesDTO> findAll() {
		List<PaisesDTO> listaDto= new ArrayList<PaisesDTO>();
		for(Paises pais:repoPaises.findAll()) {
			long conteoRegiones= obtieneConteoEm(pais.getId());
			listaDto.add(new PaisesDTO(pais.getId(), pais.getName(), conteoRegiones,new ArrayList<RegionDTO>()));
		}
		return listaDto;
	}

	
	@Override
	public PaisesRegionesDTO obtieneAmbasListas() {
		List<PaisesDTO> listaPDto= new ArrayList<PaisesDTO>();
		List<RegionDTO> listaRDto= new ArrayList<RegionDTO>();
		PaisesRegionesDTO retorno= new PaisesRegionesDTO();
		
		for(Paises pais:repoPaises.findAll()) {
			listaPDto.add(new PaisesDTO(pais.getId(), pais.getName()));
		}
		retorno.setPaises(listaPDto);
		
		for(Regiones region:repoRegiones.findAll()) {
			listaRDto.add(new RegionDTO(region.getId(), region.getIdpais(), 
					region.getSigla(), region.getDetalle()));
		}
		retorno.setRegiones(listaRDto);
		
		return retorno;
	}
	
//	private long obtieneConteo(Integer id) {
//		
//		return template.queryForObject("select count(*) from regiones where idpais=?", Long.class, new Object[] {id});
//	}
	
	
	private long obtieneConteoEm(Integer id) {
		long regiones=  (long)manager.createQuery("Select count(id) FROM Regiones r WHERE r.idpais= :id")
				.setParameter("id", id).getSingleResult();
		return regiones;
	}

	@Override
	public PaisesDTO findById(Integer id) {
		
		Optional<Paises> optional = repoPaises.findById(id);
		 PaisesDTO dto = new PaisesDTO();
		 if (optional.isPresent()) {
			 Paises pais= optional.get();
			 List<RegionDTO> regiones = new ArrayList<RegionDTO>();
			 for (Regiones reg:pais.getRegiones()) {
				 regiones.add(new RegionDTO(reg.getId(),reg.getIdpais(),reg.getSigla(),reg.getDetalle()));
			 }
			 Collections.sort(regiones);
			 
			 dto = new PaisesDTO(pais.getId(), pais.getName(),0,regiones);
			    	 
		     
		     }
		
		return dto;
	}

	@Override
	public void guardar(PaisesDTO pais) {
		Paises paisE= new Paises();
		paisE.setName(pais.getName());
		repoPaises.save(paisE);
	}
	
	
	
}
