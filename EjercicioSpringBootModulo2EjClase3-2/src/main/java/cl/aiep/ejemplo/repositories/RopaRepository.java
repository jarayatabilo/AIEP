package cl.aiep.ejemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.aiep.ejemplo.entities.RopaEntity;

@Repository
public interface RopaRepository extends JpaRepository<RopaEntity, Integer> {

}
