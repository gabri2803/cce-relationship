package it.objectmethod.ccerelationship.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ccerelationship.entity.IndirizziCliente;

@Repository
public interface IndirizziCliRepo extends JpaRepository<IndirizziCliente, Integer> {

}
