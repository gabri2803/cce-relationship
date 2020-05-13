package it.objectmethod.ccerelationship.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.ccerelationship.entity.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
