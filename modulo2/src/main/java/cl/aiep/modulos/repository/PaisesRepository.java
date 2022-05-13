package cl.aiep.modulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.modulos.repository.entity.Paises;


public interface PaisesRepository extends JpaRepository<Paises, Integer>{
	
}