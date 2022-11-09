package br.com.petz.service;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RoleInfoNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapperBuilder;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.model.Retorno;
import br.com.petz.repository.PetzClienteRepository;
import br.com.petz.repository.PetzPetRepository;

@Service
public class PetzService {

    @Autowired
    private PetzClienteRepository petzClienteRepository;

    @Autowired
    private PetzPetRepository petzPetRepository;

    public Cliente createCliente(Cliente cliente) {
        return petzClienteRepository.save(DozerBeanMapperBuilder.buildDefault().map(cliente, Cliente.class));

    }

    public Pet createPet(Pet pet) {

        return petzPetRepository.saveAndFlush(pet);

    }

    public List<Cliente> retrieveCliente() {

        return petzClienteRepository.findAll();
    }

    public List<Pet> retrievePet() {

        return petzPetRepository.findAll();
    }

    public Retorno updateClienteById(long id, Cliente cliente) {

        Retorno retorno = new Retorno();

        Optional<Cliente> updateCliente = petzClienteRepository.findById(id);

        if (updateCliente.isPresent()) {

            cliente.setCpf(cliente.getCpf());
            cliente.setNome(cliente.getNome());
            cliente.setPet(cliente.getPet());
            cliente.setSexo(cliente.getSexo());

            petzClienteRepository.save(cliente);

        }
        if (HttpStatus.OK != null && updateCliente.isPresent()) {
            retorno.setCodigo(CommonsUtils.STATUS_SUCCESS);
            retorno.setMensagem("Data Updated Successfully");

        } else {

            retorno.setCodigo(CommonsUtils.STATUS_FAIL);
            retorno.setMensagem("Unable to update data");

        }

        return retorno;
    }

    public Retorno updatePetById(long id, Pet pet) {

        Retorno retorno = new Retorno();

        Optional<Pet> updatePet = petzPetRepository.findById(id);

        if (updatePet.isPresent()) {

            pet.setIdade(pet.getIdade());
            pet.setProduto(pet.getProduto());
            pet.setTipoPet(pet.getTipoPet());
            pet.setValor(pet.getValor());

            petzPetRepository.save(pet);

        }

        if (HttpStatus.OK != null && updatePet.isPresent()) {
            retorno.setCodigo(CommonsUtils.STATUS_SUCCESS);
            retorno.setMensagem("Data Updated Successfully");

        } else {

            retorno.setCodigo(CommonsUtils.STATUS_FAIL);
            retorno.setMensagem("Unable to update data");

        }

        return retorno;
    }

    public void deleteClienteById(Long id) throws RoleInfoNotFoundException {

        Optional<Cliente> deleteCliente = petzClienteRepository.findById(id);

        if (deleteCliente.isPresent()) {
            petzClienteRepository.deleteById(id);
        } else {
            throw new RoleInfoNotFoundException("No employee record exist for given id");
        }

    }

    public void deletePetById(Long id) throws RoleInfoNotFoundException {

        Optional<Pet> deletePet = petzPetRepository.findById(id);

        if (deletePet.isPresent()) {
            petzPetRepository.deleteById(id);
        } else {
            throw new RoleInfoNotFoundException("No employee record exist for given id");
        }

    }
}