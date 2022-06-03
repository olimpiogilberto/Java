/**
 * 
 */
package br.com.mcs.beans;

/**
 * @author Gilberto
 *
 */
public class Exame {

private Integer codigo;
private String nome;
private String resultado;
private String diagnostico;

public Exame() {	}

public Exame(Integer codigo, String nome,String resultado,String diagnostico) {
	this.codigo = codigo;
	this.nome = nome;
	this.resultado = resultado;
	this.diagnostico = diagnostico;
}

public String imprime() {
	return "Código:" + this.codigo +
			"\nNome:" + this.nome+
			"\nResultado:" + this.resultado+
			"\nDiagnóstico:" + this.diagnostico;
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

public String getResultado() {
	return resultado;
}

public void setResultado(String resultado) {
	this.resultado = resultado;
}

public String getDiagnostico() {
	return diagnostico;
}

public void setDiagnostico(String diagnostico) {
	this.diagnostico = diagnostico;
}

}
