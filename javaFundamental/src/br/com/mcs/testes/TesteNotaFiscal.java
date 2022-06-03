package br.com.mcs.testes;

import javax.swing.JOptionPane;

import br.com.mcs.beans.*;

public class TesteNotaFiscal {

public static void main(String[] args) {
		
	Endereco end = new Endereco("Rua Bertioga",275,6826200);
	Pessoa cliente = new Pessoa(3267l,"Gilberto Olimpio",end);
	Produto prod = new Produto(1,"Parafuso",1.45f,2.99f);
	NotaFiscal nota = new NotaFiscal(cliente,prod,199.00f);
	System.out.println(nota.imprime());
	JOptionPane.showMessageDialog(null, nota.imprime());
	}// Fim do main

}
