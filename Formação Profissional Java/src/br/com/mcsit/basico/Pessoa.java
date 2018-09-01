package br.com.mcsit.basico;

import br.com.mcsit.basico.Endereco;

public class Pessoa{
	private long cpf;
	private String nome;
	private Endereco endereco = new Endereco();
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
}
