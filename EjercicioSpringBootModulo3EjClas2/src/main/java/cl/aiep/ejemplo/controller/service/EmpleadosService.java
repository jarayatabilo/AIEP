package cl.aiep.ejemplo.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aiep.ejemplo.dao.IEmpleadosDAO;
import cl.aiep.ejemplo.dao.dto.EmpresaDTO;

@Service
public class EmpleadosService {
	
	@Autowired
	IEmpleadosDAO empleadosDAO;
	
	public EmpresaDTO obtenerEmpleados(){
		
		return empleadosDAO.obtenerEmpleados();
	}

}
