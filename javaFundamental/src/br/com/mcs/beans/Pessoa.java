package br.com.mcs.beans;

public class Pessoa {
	private long cpf;
	private String nome;
	private String sexo;
	private Endereco logradouro = new Endereco();

// MÉTODO CONSTRUTOR
public Pessoa() {

	}

//MÉTODO CONSTRUTOR ALTERNATIVO
public Pessoa(long cpf, String nome, Endereco logradouro) {
	
	this.cpf = cpf;
	this.nome = nome;
	this.logradouro = logradouro;
}

  //IMPRIME 
public String imprime(){
	return "CPF: "+ this.cpf+ 
	        "\nNome: "+ this.nome+
	        "\n------- Endereço -------- " +
	        "\n" + this.logradouro.imprime();
}//FIM DO IMPRIME 	

	//GETTERS E SETTERS
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
	
    public Endereco getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(Endereco logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}//FIM DA CLASSE
