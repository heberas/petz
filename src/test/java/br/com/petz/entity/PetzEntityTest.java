package br.com.petz.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.petz.model.Cliente;

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
public class PetzEntityTest {

	@Test
	public void testPetzEntity() {

		Cliente test = new Cliente();

		test.setNome("nome");
		test.setSexo("sexo");
		test.setCpf("cpf");
		test.setPet("pet");

		Assert.assertEquals(test.getNome(), "nome");
		Assert.assertEquals(test.getSexo(), "sexo");
		Assert.assertEquals(test.getCpf(), "cpf");
		Assert.assertEquals(test.getPet(), "pet");

	}
}