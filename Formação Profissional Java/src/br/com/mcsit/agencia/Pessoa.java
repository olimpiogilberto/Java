package br.com.mcsit.agencia;

import java.util.List;

import br.com.mcsit.basico.Endereco;

public class Pessoa extends Cliente{
	private long cpf;
	private String rg;
	private List<Endereco> endereco;
	
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public List<Endereco> getEndereco() {
		return endereco;
	}
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	

}
