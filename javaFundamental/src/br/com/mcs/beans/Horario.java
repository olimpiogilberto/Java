/**
 * 
 */
package br.com.mcs.beans;

/**
 * @author Gilberto
 *
 */
public class Horario {
private Integer dia;
private Integer horaInicio;
private Integer minutoInicio;
private Integer duracao;

public Horario() {
	
}	

public Horario(Integer dia, Integer horaInicio, Integer minutoInicio, Integer duracao) {
	this.dia = dia;
	this.horaInicio = horaInicio;
	this.minutoInicio = minutoInicio;
	this.duracao = duracao;
	
}

public String imprime() {
	return 	"\nDia:" + this.dia +
			"\nHora: " + this.horaInicio +":" + this.minutoInicio +
			"\nDuração: " + this.duracao;
}

public Integer getDia() {
	return dia;
}

public void setDia(Integer dia) {
	this.dia = dia;
}

public Integer getHoraInicio() {
	return horaInicio;
}

public void setHoraInicio(Integer horaInicio) {
	this.horaInicio = horaInicio;
}

public Integer getMinutoInicio() {
	return minutoInicio;
}

public void setMinutoInicio(Integer minutoInicio) {
	this.minutoInicio = minutoInicio;
}

public Integer getDuracao() {
	return duracao;
}

public void setDuracao(Integer duracao) {
	this.duracao = duracao;
}

}
