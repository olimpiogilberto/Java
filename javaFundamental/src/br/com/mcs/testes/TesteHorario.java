package br.com.mcs.testes;

import javax.swing.JOptionPane;

import br.com.mcs.beans.*;

public class TesteHorario {

	public static void main(String[] args) {

		Horario data = new Horario(10,13,04,50);
		System.out.println(data.imprime());
		
		//JOptionPane.showMessageDialog(null,data.imprime());

}//Fim do método main

}
