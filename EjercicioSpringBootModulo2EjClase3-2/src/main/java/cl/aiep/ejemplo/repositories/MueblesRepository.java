package cl.aiep.ejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.entities.MueblesEntity;

@Repository
public interface MueblesRepository extends JpaRepository<MueblesEntity, Integer>{

}
