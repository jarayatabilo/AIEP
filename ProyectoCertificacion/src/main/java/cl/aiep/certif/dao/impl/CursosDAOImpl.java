package cl.aiep.certif.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.certif.dao.ICursosDAO;
import cl.aiep.certif.dao.dto.ContenidoDTO;
import cl.aiep.certif.dao.dto.CursoDTO;
import cl.aiep.certif.dao.entity.Contenido;
import cl.aiep.certif.dao.entity.Curso;
import cl.aiep.certif.dao.repository.ContenidoRepository;
import cl.aiep.certif.dao.repository.CursoRepository;

@Repository
public class CursosDAOImpl implements ICursosDAO{
	
	
	@Autowired
	CursoRepository repoCurso;
	
	@Autowired
	ContenidoRepository repoContenido;
	
	@Autowired
	JdbcTemplate jdbcTemp;

	@Override 
	public List<CursoDTO> obtenerCursos() {
		List<CursoDTO> retorno= new ArrayList<CursoDTO>();
		for(Curso curso:repoCurso.findAll())
			retorno.add(new CursoDTO(curso.getId(), curso.getNombre(),
					curso.getImagen(), curso.getFecinicio(),
					curso.getFectermino(), curso.getCupos(), curso.getDescripcion() ));
		
		return retorno;
	}

	@Override
	public CursoDTO obtenerCurso(Integer id) {
		Optional<Curso> optional = repoCurso.findById(id);
		Curso curso = new Curso();
		if(optional.isPresent())
			curso = (Curso)optional.get();
			
		return new CursoDTO(curso.getId(), curso.getNombre(),
				curso.getImagen(), curso.getFecinicio(),
				curso.getFectermino(), curso.getCupos(), curso.getDescripcion() );
	}

	@Override
	public boolean guardarCurso(CursoDTO curso) {
		repoCurso.save(new Curso(curso.getNombre(), curso.getImagen(),
				new Date(curso.getFecinicio().getTime()),new Date(curso.getFectermino().getTime()),curso.getCupos(),
				curso.getDescripcion()));
		return false;
	}

	@Override
	public boolean actualizarCurso(CursoDTO curso) {
		repoCurso.save(new Curso());
		return false;
	}

	@Override
	public boolean eliminarCurso(Integer id) {
		boolean retorno=true;
		try {
		repoCurso.deleteById(id);
		}catch (Exception e) {
			retorno= false;
		}
		return retorno;
	}

	@Override
	public int obtenerCupos(Integer id) {
		return jdbcTemp.queryForObject("select count(*) from curso where id=?", Integer.class, new Object[] {id});
	}

	@Override
	public void guardarContenido(ContenidoDTO contenido) {
		repoContenido.save(new Contenido());
		
	}

	@Override
	public boolean actualizarContenido(ContenidoDTO contenido) {
		repoContenido.save(new Contenido());
		return false;
	}

	@Override
	public boolean eliminarContenido(Integer id) {
		repoContenido.deleteById(id);
		return false;
	}
	
	

}
