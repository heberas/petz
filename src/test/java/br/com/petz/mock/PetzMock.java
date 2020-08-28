package br.com.petz.mock;

import java.util.Date;
import java.util.List;

import org.assertj.core.util.Lists;
import org.mockito.Mock;

import br.com.petz.entity.PetzEntityTest;
import br.com.petz.model.Cliente;

public class PetzMock {

	@Mock
	PetzEntityTest petzEntityTest;

	public List<PetzEntityTest> getListaArquivosPetzMock() {

		return Lists.newArrayList(petzEntityTest);
	}

	public Cliente getMockClientePetz() {

		Cliente mock = new Cliente();
		Date data = new Date();

		mock.setNome(data.toString());
		mock.setSexo(data.toString());
		mock.setCpf(data.toString());
		mock.setPet(data.toString());

		return mock;
	}
}