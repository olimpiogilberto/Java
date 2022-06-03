/**
 * 
 */
package br.com.mcs.beans;

/**
 * @author Gilberto
 *
 */
public class Comanda {
	//ATRIBUTOS
private Integer numero;
private Produto produtos;
private float total;

   //MÉTODO CONSTRUTOR PADRÃO
public Comanda() { 	}

  //MÉTODO CONSTRUTOR ALTERNATIVO
public Comanda(Integer numero, Produto produtos, float total) {
	this.numero = numero;
	this.produtos = produtos;
	this.total = total;
}
  //IMPRIME
public String imprime(){
	return "Comanda: "+ this.numero+ 
	        "\n"+ this.produtos.imprime()+
	        "\n" + this.total;
}//FIM DO IMPRIME 	
  //GETTERS E SETTERS  
public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public Produto getProdutos() {
	return produtos;
}

public void setProdutos(Produto produtos) {
	this.produtos = produtos;
}

public float getTotal() {
	return total;
}

public void setTotal(float total) {
	this.total = total;
}

}  //FIM DA CLASSE
