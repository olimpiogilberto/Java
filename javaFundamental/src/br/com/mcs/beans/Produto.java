/**
 * 
 */
package br.com.mcs.beans;

/**
 * @author Gilberto
 *
 */
public class Produto {

private Integer codigo;
private String nome;
private float custo;
private float preco;

public Produto() {}

//IMPRIME
public Produto(Integer codigo, String nome, float custo, float preco ) {
this.codigo = codigo;
this.nome = nome;
this.custo = custo;
this.preco = preco; }//FIM

//IMPRIME
public String imprime(){
return "Código: "+ this.codigo+ 
       "\nNome: "+ this.nome +
	   "\nCusto: "+ this.custo +
	   "\nPreco: "+ this.preco;
}	
public Integer getCodigo() {
	return codigo;
}

public void setCodigo(Integer codigo) {
	this.codigo = codigo;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public float getCusto() {
	return custo;
}

public void setCusto(float custo) {
	this.custo = custo;
}

public float getPreco() {
	return preco;
}

public void setPreco(float preco) {
	this.preco = preco;
}

}
