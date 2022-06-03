package br.com.mcs.beans;

public class Endereco {
private Integer cep;
private String rua;
private Integer numero;
private String bairro;

public Endereco(){}



public Endereco(String rua, Integer numero, Integer cep) {
	// TODO Auto-generated method stub
	this.cep = cep;
	this.rua = rua;
	this.numero = numero;
}

public String imprime(){
return "CEP: "+ this.cep+ 
        "\nRua: "+ this.rua+
        "\nNúmero: " +this.numero;
}


//GETTERS E SETTERS
public Integer getCep() {
	return cep;
}
public void setCep(Integer cep) {
	this.cep = cep;
}
public String getRua() {
	return rua;
}
public void setRua(String rua) {
	this.rua = rua;
}
public Integer getNumero() {
	return numero;
}
public void setNumero(Integer numero) {
	this.numero = numero;
}



/**
 * @return the bairro
 */
public String getBairro() {
	return bairro;
}



/**
 * @param bairro the bairro to set
 */
public void setBairro(String bairro) {
	this.bairro = bairro;
}

}
