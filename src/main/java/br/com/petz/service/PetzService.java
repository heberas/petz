package br.com.petz.service;

import br.com.petz.model.Cliente;
import br.com.petz.model.Pet;
import br.com.petz.model.Response;
import br.com.petz.repository.PetzClienteRepository;
import br.com.petz.repository.PetzPetRepository;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfoNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PetzService {

    @Autowired
    private PetzClienteRepository petzClienteRepository;

    @Autowired
    private PetzPetRepository petzPetRepository;

    public Cliente creatingClient(Cliente cliente) {
        try {
            return petzClienteRepository.save(DozerBeanMapperBuilder.buildDefault().map(cliente, Cliente.class));
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Pet creatingPet(Pet pet) {
        try {
            return petzPetRepository.saveAndFlush(pet);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Cliente> retrievingClient() {
        try {
            return petzClienteRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public List<Pet> retrievingPet() {
        try {
            return petzPetRepository.findAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Response updatingClient(long id, Cliente cliente) {

        Response response = new Response();
        try {
            Optional<Cliente> updateCliente = petzClienteRepository.findById(id);

            if (updateCliente.isPresent()) {
                Cliente update = new Cliente();
                update.setId(id);
                update.setCpf(cliente.getCpf());
                update.setNome(cliente.getNome());
                update.setPet(cliente.getPet());
                update.setSexo(cliente.getSexo());

                petzClienteRepository.save(update);
                response.setMessage("Data Updated Successfully");
            } else {
                response.setMessage("Unable to update data");
            }
        } catch (Exception ex) {
            throw ex;
        }

        return response;
    }

    public Response updatingPet(long id, Pet pet) {

        Response response = new Response();
        try {
            Optional<Pet> updatePet = petzPetRepository.findById(id);

            if (updatePet.isPresent()) {
                Pet update = new Pet();
                update.setId(id);
                update.setIdade(pet.getIdade());
                update.setProduto(pet.getProduto());
                update.setTipoPet(pet.getTipoPet());
                update.setValor(pet.getValor());

                petzPetRepository.save(update);
                response.setMessage("Data Updated Successfully");
            } else {
                response.setMessage("Unable to update data");
            }
        } catch (Exception ex) {
            throw ex;
        }

        return response;
    }

    public void deletingClientById(Long id) throws RoleInfoNotFoundException {
        try {
            Optional<Cliente> deleteCliente = petzClienteRepository.findById(id);

            if (deleteCliente.isPresent()) {
                petzClienteRepository.deleteById(id);
            } else {
                throw new RoleInfoNotFoundException("No employee record exist for given id");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void deletingPetById(Long id) throws RoleInfoNotFoundException {
        try {
            Optional<Pet> deletePet = petzPetRepository.findById(id);

            if (deletePet.isPresent()) {
                petzPetRepository.deleteById(id);
            } else {
                throw new RoleInfoNotFoundException("No employee record exist for given id");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}