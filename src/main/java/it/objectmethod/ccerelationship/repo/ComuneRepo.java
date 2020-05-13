package it.objectmethod.ccerelationship.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ccerelationship.entity.Comune;

@Repository
public interface ComuneRepo extends JpaRepository<Comune, Integer> {

}
