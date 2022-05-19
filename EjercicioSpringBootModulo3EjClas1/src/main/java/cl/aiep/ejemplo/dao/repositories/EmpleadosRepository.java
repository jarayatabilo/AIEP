package cl.aiep.ejemplo.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.dao.entities.EmpleadoEntity;


@Repository
public interface EmpleadosRepository extends JpaRepository<EmpleadoEntity, Integer>{

}
