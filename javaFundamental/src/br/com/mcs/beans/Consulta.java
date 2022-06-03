/**
 * 
 */
package br.com.mcs.beans;

import java.util.List;

/**
 * @author Gilberto
 *
 */
public class Consulta {

private Pessoa paciente;
private List<Exame> exames;
private Integer diaConsulta;
private Horario retorno;


public Consulta() {	}

public Consulta(Pessoa paciente, List<Exame> exames, Integer diaConsulta, Horario retorno) {
	this.paciente = paciente;
	this.exames = exames;
	this.diaConsulta = diaConsulta;
	this.retorno = retorno;
}

public String imprime() {
	return  "\n" + this.paciente.imprime()+
			"\n" + this.exames.get(0) +
			"\nDia:" + this.diaConsulta +
			"\nRetorno" + this.retorno.imprime();
}

public Pessoa getPaciente() {
	return paciente;
}


public void setPaciente(Pessoa paciente) {
	this.paciente = paciente;
}


public List<Exame> getExames() {
	return exames;
}


public void setExames(List<Exame> exames) {
	this.exames = exames;
}


public Integer getDiaConsulta() {
	return diaConsulta;
}


public void setDiaConsulta(Integer diaConsulta) {
	this.diaConsulta = diaConsulta;
}


public Horario getRetorno() {
	return retorno;
}


public void setRetorno(Horario retorno) {
	this.retorno = retorno;
}

}
