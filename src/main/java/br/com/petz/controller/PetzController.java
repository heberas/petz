package br.com.petz.controller;

import br.com.petz.handler.exception.BusinessException;
import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.model.Response;
import br.com.petz.service.PetzService;
import io.swagger.annotations.Api;
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

    @PostMapping("/create/cliente")
    public ResponseEntity<Cliente> creatingClient(@RequestBody Cliente cliente) throws Throwable {
        return new ResponseEntity<>(petzService.creatingClient(cliente), HttpStatus.CREATED);

    }

    @PostMapping("/create/pet")
    public ResponseEntity<Pet> creatingPet(@RequestBody Pet pet) {
        return new ResponseEntity<>(petzService.creatingPet(pet), HttpStatus.CREATED);
    }

    @GetMapping("/retrieve/cliente")
    public ResponseEntity<List<Cliente>> retrievingClient() {
        return new ResponseEntity<>(petzService.retrievingClient(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/retrieve/pet")
    public ResponseEntity<List<Pet>> retrievingPet() {
        return new ResponseEntity<>(petzService.retrievingPet(), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update/cliente/{id}")
    public ResponseEntity<Response> updatingClient(@PathVariable("id") long id, @RequestBody Cliente cliente) throws BusinessException {
        return ResponseEntity.ok(petzService.updatingClient(id, cliente));

    }

    @PutMapping("/update/pet/{id}")
    public ResponseEntity<Response> updatingPet(@PathVariable("id") long id, @RequestBody Pet pet) throws BusinessException {
        return ResponseEntity.ok(petzService.updatingPet(id, pet));
    }

    @DeleteMapping("/delete/cliente")
    public ResponseEntity<HttpStatus> deletingClientById(@RequestParam(required = true) long id) throws RoleInfoNotFoundException {
        petzService.deletingClientById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/pet")
    public ResponseEntity<HttpStatus> deletingPetById(@RequestParam(required = true) long id) throws RoleInfoNotFoundException {
        petzService.deletingPetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
