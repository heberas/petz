package br.com.petz.model;

public class Retorno {

	private String codigo;
	private String mensagem;

	public Retorno() {
	}

	public Retorno(String codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
