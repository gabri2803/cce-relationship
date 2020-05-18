package it.objectmethod.ccerelationship.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.ccerelationship.entity.Cliente;
import it.objectmethod.ccerelationship.entity.IndirizziCliente;
import it.objectmethod.ccerelationship.repo.ClienteRepo;

@RestController
@RequestMapping("relationship/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepo clienteRepo;

	@GetMapping("/{id}/findById")
	public ResponseEntity<Cliente> findById(@PathVariable("id") int id) {
		ResponseEntity<Cliente> response = null;
		Optional<Cliente> cli = null;
		try {
			cli = clienteRepo.findById(id);
			response = new ResponseEntity<>(cli.get(), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping("/save")
	public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente c) {
		ResponseEntity<Cliente> response = null;
		try {
			for (IndirizziCliente indirizzi : c.getIndirizzi()) {
				indirizzi.setCliente(c);
			}
			Cliente cli = clienteRepo.save(c);
			response = new ResponseEntity<>(cli, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
