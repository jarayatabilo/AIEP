package cl.aiep.ejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.entities.Comida;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Integer>{
     
}
