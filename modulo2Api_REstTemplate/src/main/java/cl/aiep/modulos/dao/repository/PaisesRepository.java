package cl.aiep.modulos.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.modulos.dao.repository.entity.Paises;

@Repository
public interface PaisesRepository extends JpaRepository<Paises, Integer>{
	
	List<Paises> findByNameStartingWith(String valor);
	
}