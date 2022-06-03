package br.com.mcs.beans;

public class Conta {

	private Pessoa titular;
	private Integer agencia;
	private Integer numero;
	private Integer digito;
	private float saldo;
	
	public Conta() {
		// TODO Auto-generated constructor stub
	}
	//MÉTODO CONSTRUTOR ALTERNATIVO
	public Conta(Pessoa titular, Integer agencia, Integer numero, Integer digito, float saldo) {
		
		this.titular = titular;
		this.agencia = agencia;
		this.numero = numero;
		this.digito = digito;
		this.saldo = saldo;
	}
	
	public String imprime(){
		return "CPF: "+ this.titular.imprime()+ 
		        "\nAgência: "+ this.agencia+
		         "\nConta: "+ this.numero+ "-"+ this.digito+
		           "\nSaldo: "+ this.saldo;
		}	
	public String imprimeCerto(){
		return "Titular:" + this.titular.getNome() +
				"\nCPF:" + this.titular.getCpf()+
				"\n ------ CONTA  ---------" +
		        "\nAgência: "+ this.agencia+
		         "\nConta: "+ this.numero+ "-"+ this.digito+
		           "\nSaldo: "+ this.saldo +
		           "\n ------ ENDERECO  ---------" +
		           "\n" + this.titular.getLogradouro().imprime();
		}	
	public Pessoa getTitular() {
		return titular;
	}

	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getDigito() {
		return digito;
	}

	public void setDigito(Integer digito) {
		this.digito = digito;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
