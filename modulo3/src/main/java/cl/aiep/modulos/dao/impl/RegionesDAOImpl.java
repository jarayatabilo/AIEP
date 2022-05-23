package cl.aiep.modulos.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.aiep.modulos.dao.IRegionesDAO;
import cl.aiep.modulos.repository.RegionesRepository;
import cl.aiep.modulos.repository.dto.RegionDTO;
import cl.aiep.modulos.repository.entity.Regiones;

@Repository
public class RegionesDAOImpl implements IRegionesDAO{

	@Autowired
	RegionesRepository repositorio;
	
	@Override
	public RegionDTO obtenerRegion(Integer id) {
		Optional<Regiones> optional = repositorio.findById(id);
		Regiones reg= new Regiones();
		if (optional.isPresent()) 
			 reg= optional.get();
	
		return new RegionDTO(reg.getId(), reg.getIdpais(), reg.getSigla(), reg.getDetalle());
		
	}

}
