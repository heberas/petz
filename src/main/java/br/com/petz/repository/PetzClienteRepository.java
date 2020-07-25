package br.com.petz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.model.Cliente;

public interface PetzClienteRepository extends JpaRepository<Cliente, Long> {

}