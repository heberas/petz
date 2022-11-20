package br.com.petz.controller;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.model.Retorno;
import br.com.petz.service.PetzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.RoleInfoNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/petz")
@Api(value = "API PETZ")
public class PetzController {

	@Autowired
	private PetzService petzService;
	
	@ApiOperation(value = "Creating new client")
	@PostMapping("/create/cliente")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) throws Throwable {
		return new ResponseEntity<>(petzService.createCliente(cliente), HttpStatus.CREATED);

	}
	@ApiOperation(value = "Creating new pet")
	@PostMapping("/create/pet")
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
		return new ResponseEntity<>(petzService.createPet(pet), HttpStatus.CREATED);
	}

	@GetMapping("/retrieve/cliente")
	public ResponseEntity<List<Cliente>> listandoCliente() {
		return new ResponseEntity<>(petzService.retrieveCliente(), new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/retrieve/pet")
	public ResponseEntity<List<Pet>> listandoPet() {
		return new ResponseEntity<>(petzService.retrievePet(), new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/update/cliente/{id}")
	public ResponseEntity<Retorno> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {

		petzService.updateClienteById(id, cliente);

		return ResponseEntity.ok(petzService.updateClienteById(id, cliente));

	}

	@PutMapping("/update/pet/{id}")
	public ResponseEntity<Retorno> updatePet(@PathVariable("id") long id, @RequestBody Pet pet) {

		petzService.updatePetById(id, pet);

		return ResponseEntity.ok(petzService.updatePetById(id, pet));
	}

	@DeleteMapping("/delete/cliente")
	public ResponseEntity<HttpStatus> deleteClienteById(@RequestParam (required = true) long id) throws RoleInfoNotFoundException {

		petzService.deleteClienteById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/pet")
	public ResponseEntity<HttpStatus> deletePetById(@RequestParam (required = true)  long id) throws RoleInfoNotFoundException {

		petzService.deletePetById(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
