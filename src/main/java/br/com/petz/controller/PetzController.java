package br.com.petz.controller;

import java.util.List;

import javax.management.relation.RoleInfoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.service.PetzService;

@RestController
@RequestMapping("/api/petz")
public class PetzController {

	@Autowired
	private PetzService petzService;

	@PostMapping("/create/cliente")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) throws RoleInfoNotFoundException {
		return new ResponseEntity<Cliente>(petzService.createCliente(cliente), HttpStatus.OK);
	}

	@PostMapping("/create/pet")
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet) throws RoleInfoNotFoundException {
		return new ResponseEntity<Pet>(petzService.createPet(pet), HttpStatus.OK);
	}

	@GetMapping("/retrieve/cliente")
	public ResponseEntity<List<Cliente>> listandoCliente() {
		return new ResponseEntity<List<Cliente>>(petzService.retrieveCliente(), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/retrieve/pet")
	public ResponseEntity<List<Pet>> listandoPet() {
		return new ResponseEntity<List<Pet>>(petzService.retrievePet(), new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/update/cliente/{id}")
	public ResponseEntity<HttpStatus> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente)
			throws RoleInfoNotFoundException {

		petzService.updateClienteById(id, cliente);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/update/pet/{id}")
	public ResponseEntity<HttpStatus> updatePet(@PathVariable("id") long id, @RequestBody Pet pet)
			throws RoleInfoNotFoundException {

		petzService.updatePetById(id, pet);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/cliente/{id}")
	public ResponseEntity<HttpStatus> deleteClienteById(@PathVariable("id") long id) throws RoleInfoNotFoundException {

		petzService.deleteClienteById(id);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/pet/{id}")
	public ResponseEntity<HttpStatus> deletePetById(@PathVariable("id") long id) throws RoleInfoNotFoundException {

		petzService.deletePetById(id);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}