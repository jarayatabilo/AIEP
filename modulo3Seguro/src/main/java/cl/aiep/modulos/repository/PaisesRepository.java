package cl.aiep.modulos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.modulos.repository.entity.Paises;

@Repository
public interface PaisesRepository extends JpaRepository<Paises, Integer>{
	
}