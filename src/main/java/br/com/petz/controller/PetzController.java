package br.com.petz.controller;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.model.Response;
import br.com.petz.service.PetzService;
import io.swagger.annotations.Api;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/petz")
@Api(value = "API PETZ")
public class PetzController {

    @Autowired
    private PetzService petzService;

    @PostMapping("/create/cliente")
    public ResponseEntity<Cliente> creatingClient(@RequestBody Cliente cliente) {
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
    public ResponseEntity<Response> updatingClient(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(petzService.updatingClient(id, cliente));

    }

    @PutMapping("/update/pet/{id}")
    public ResponseEntity<Response> updatingPet(@PathVariable("id") long id, @RequestBody Pet pet) {
        return ResponseEntity.ok(petzService.updatingPet(id, pet));
    }

    @DeleteMapping("/delete/cliente")
    public ResponseEntity<HttpStatus> deletingClientById(@RequestParam(required = true) long id) {
        petzService.deletingClientById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/pet")
    public ResponseEntity<HttpStatus> deletingPetById(@RequestParam(required = true) long id) {
        petzService.deletingPetById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
