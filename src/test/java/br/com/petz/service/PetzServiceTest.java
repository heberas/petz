package br.com.petz.service;

import static org.mockito.Mockito.when;

import javax.management.relation.RoleInfoNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.petz.mock.PetzMock;
import br.com.petz.model.Cliente;
import br.com.petz.repository.PetzClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class PetzServiceTest extends PetzMock {

	@Mock
	private PetzClienteRepository petzClienteRepository;

	@Spy
	@InjectMocks
	private PetzService petzService;

	@Test
	public void testClientePetz() throws RoleInfoNotFoundException {

		Cliente codMockTest = new Cliente();
		codMockTest.setNome("COD-TEST");
		codMockTest.setCpf("02503199500");
		codMockTest.setPet("Cachorro-TEST");
		codMockTest.setSexo("Masculino-TEST");

		Cliente mockCliente = new Cliente();
		mockCliente.setNome(codMockTest.toString());
		mockCliente.setCpf(codMockTest.toString());
		mockCliente.setPet(codMockTest.toString());
		mockCliente.setSexo(codMockTest.toString());

		when(petzService.createCliente(codMockTest)).thenReturn(mockCliente);
	}

}