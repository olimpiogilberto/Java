package br.com.mcs.testes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.mcs.beans.*;

public class TesteConsulta {

public static void main(String[] args) {

	Endereco end = new Endereco("Rua Bertioga",275,6826200);
	Pessoa cliente = new Pessoa(3267l,"Gilberto Olimpio",end);
	Horario retorno = new Horario(10,13,04,50);
	Exame e = new Exame(1,"Exame de Vista", "OK","OK");
	Exame ex = new Exame(2,"Exame Completo", "NOK","NOK");
	List<Exame> exames;
	exames = new ArrayList<Exame>();
	exames.add(e);
	exames.add(ex);
	Consulta consulta = new Consulta(cliente,exames, 10,retorno);
	System.out.println(consulta.imprime());
	JOptionPane.showMessageDialog(null, consulta.imprime());
	}// end of the main
}//end of the class

