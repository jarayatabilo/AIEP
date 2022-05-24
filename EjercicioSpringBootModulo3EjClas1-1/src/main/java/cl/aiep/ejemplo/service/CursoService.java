package cl.aiep.ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.ejemplo.dao.EscuelaDAO;
import cl.aiep.ejemplo.dao.dto.CursoDTO;

@Service
public class CursoService {
	
	@Autowired
	EscuelaDAO cursodao;
	
	public List<CursoDTO> obtieneCurso(){
		
		return cursodao.obtenerCurso();
	}

}
