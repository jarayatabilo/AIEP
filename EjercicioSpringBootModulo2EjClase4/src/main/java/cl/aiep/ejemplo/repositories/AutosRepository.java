package cl.aiep.ejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.entities.AutosEntity;

@Repository
public interface AutosRepository extends JpaRepository<AutosEntity, Integer>{

}
