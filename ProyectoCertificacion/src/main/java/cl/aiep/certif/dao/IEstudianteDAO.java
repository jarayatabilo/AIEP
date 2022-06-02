package cl.aiep.certif.dao;

import java.util.List;

import cl.aiep.certif.dao.dto.CursoDTO;
import cl.aiep.certif.dao.dto.EstudianteDTO;
import cl.aiep.certif.dao.dto.RegionDTO;

public interface IEstudianteDAO {
	
	public List<EstudianteDTO> obtenerEstudiantes();
	public EstudianteDTO obtenerEstudiante(String rut);
	public boolean guardaEstudiante(EstudianteDTO estudiante);
	public boolean actualizaEstudiante(EstudianteDTO estudiante);
	public boolean eliminaEstudiante(Integer id);
	public List<CursoDTO> obtieneCursos(String rut);
	public boolean agregaCursos(EstudianteDTO estudiante);
	public List<RegionDTO> obtieneRegiones();
}
