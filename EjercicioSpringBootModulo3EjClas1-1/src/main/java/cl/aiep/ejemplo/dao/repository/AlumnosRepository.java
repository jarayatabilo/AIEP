package cl.aiep.ejemplo.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.dao.entities.AlumnosEntity;

@Repository
public interface AlumnosRepository extends JpaRepository<AlumnosEntity, Integer>{

}
