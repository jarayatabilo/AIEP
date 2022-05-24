package cl.aiep.ejemplo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.dao.EscuelaDAO;
import cl.aiep.ejemplo.dao.dto.AlumnosDTO;
import cl.aiep.ejemplo.dao.dto.CursoDTO;
import cl.aiep.ejemplo.dao.entities.AlumnosEntity;
import cl.aiep.ejemplo.dao.entities.CursoEntity;
import cl.aiep.ejemplo.dao.repository.CursoRepository;


@Repository
public class EscuelaDAOImpl  implements EscuelaDAO{
	
	@Autowired
	CursoRepository crepository;

	@Override
	public List<CursoDTO> obtenerCurso() {
		List <CursoDTO> retorno= new ArrayList<CursoDTO>();
		
		for (CursoEntity entidad: crepository.findAll()) {
			CursoDTO curso= new CursoDTO(entidad.getId(), entidad.getNombre(),entidad.getDetalle(),
					entidad.getProfesor(),new ArrayList<AlumnosDTO>());
			for(AlumnosEntity alum:entidad.getAlumnos())
				curso.getAlumnos().add(new AlumnosDTO(alum.getId(),alum.getNombre(),alum.getEdad(), 
						alum.getDomicilio()));	
			retorno.add(curso);
		}
		
		return retorno;
	}
	
	
}
