package cl.aiep.certif.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.certif.dao.ICursosDAO;
import cl.aiep.certif.dao.dto.CursoDTO;

@Service
public class CursoService {
	
	@Autowired
	ICursosDAO dao;
	
	public List<CursoDTO> obtenerCursos(){
		return dao.obtenerCursos();
	}
	
	public CursoDTO obtenerCurso(Integer id){
		return dao.obtenerCurso(id);
	}

	public void guardarCurso(CursoDTO curso) {
		dao.guardarCurso(curso);
		
	}

}
