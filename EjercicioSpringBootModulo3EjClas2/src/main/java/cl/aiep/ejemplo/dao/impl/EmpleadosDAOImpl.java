package cl.aiep.ejemplo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.dao.IEmpleadosDAO;
import cl.aiep.ejemplo.dao.dto.EmpleadoDTO;
import cl.aiep.ejemplo.dao.dto.EmpresaDTO;
import cl.aiep.ejemplo.dao.entities.EmpleadoEntity;
import cl.aiep.ejemplo.dao.entities.EmpresaEntity;
import cl.aiep.ejemplo.dao.repositories.EmpleadosRepository;
import cl.aiep.ejemplo.dao.repositories.EmpresaRepository;


@Repository
public class EmpleadosDAOImpl implements IEmpleadosDAO{

	@Autowired
	EmpleadosRepository repoEmple;
	
	@Autowired
	EmpresaRepository repoEmpre;
	
	@Override
	public EmpresaDTO obtenerEmpleados() {
		
		List<EmpresaEntity> result=  repoEmpre.findAll();
		
		List<EmpleadoEntity> empleados= repoEmple.findAll();
		EmpresaDTO retorno = new EmpresaDTO();
		
		if(result.size()>0) {
			retorno = new EmpresaDTO(result.get(0).getId(),result.get(0).getNombre(),
					result.get(0).getCantEmpleado(),
					result.get(0).getSucursal(),result.get(0).getRut(),null);
		}
		
		retorno.setEmpleados(new ArrayList<EmpleadoDTO>());
		for(EmpleadoEntity emple:empleados ) {
			retorno.getEmpleados().add(new EmpleadoDTO(emple.getId(), 
					emple.getNombre(), emple.getCargo(), emple.getEdad(),
					emple.getSueldo(), emple.getJornada()));
		}
		return retorno;
	}

}
