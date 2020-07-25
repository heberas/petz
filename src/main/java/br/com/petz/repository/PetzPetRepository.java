package br.com.petz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.model.Pet;

public interface PetzPetRepository extends JpaRepository<Pet, Long> {

}