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

		Cliente arquivos = new Cliente();
		Date data = new Date();

		arquivos.setNome(data.toString());
		arquivos.setSexo(data.toString());
		arquivos.setCpf(data.toString());
		arquivos.setPet(data.toString());

		return arquivos;
	}
}