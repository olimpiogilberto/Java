package br.com.mcs.testes;

import javax.swing.JOptionPane;

import br.com.mcs.beans.*;

public class TesteComanda {

public static void main(String[] args) {
	
	Produto prod = new Produto(36,"Costelinha",1.5f,2.99f);
	Comanda comanda = new Comanda(1,prod,2);
	JOptionPane.showMessageDialog(null, comanda.imprime());

	}//Fim do main

}
