package br.com.mcs.beans;

public class NotaFiscal {

private Pessoa cliente;
private Produto produto;
private float total;

//Default Constructor 
public NotaFiscal() {}

//Alternative Constructor 
public NotaFiscal(Pessoa cliente,Produto produto, float total) {
	this.cliente = cliente;
	this.produto = produto;
	this.total = total;
}

//Imprime 
public String imprime() {
	return  "------- Cliente --------- " +
			"\n"+ this.cliente.imprime()+
			"\n------- Compra ---------- " +
		    "\n"+ this.produto.imprime()+
		    "\n"+ this.total;

}

public Pessoa getCliente() {
	return cliente;
}

public void setCliente(Pessoa cliente) {
	this.cliente = cliente;
}

public Produto getProduto() {
	return produto;
}

public void setProduto(Produto produto) {
	this.produto = produto;
}

public float getTotal() {
	return total;
}

public void setTotal(float total) {
	this.total = total;
}

}//Fim da Classe
