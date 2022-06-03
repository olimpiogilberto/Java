package br.com.mcs.beans;

public class Aluno extends Pessoa{

//ATRIBUTOS
private Integer ra;

//CONSTRUTOR PADRÃO
public Aluno() {
	
}

public Aluno(Integer ra, long cpf,String nome, Endereco logradouro) {
	super(cpf,nome,logradouro);
	
	this.ra = ra;
}

public Aluno(Integer ra, Pessoa pessoa) {
	super(pessoa.getCpf(), pessoa.getNome(), pessoa.getLogradouro());
	
	this.ra = ra;
}

public String imprime(){//SOBRESCRITA
return "RA: "+ this.getRa()+ 
	 "\n" + super.imprime();
		}

//GETTERS E SETTERS
public Integer getRa() {
		return ra;
	}
public void setRa(Integer ra) {
		this.ra = ra;
	}



}
