package br.com.mcs.testes;

import javax.swing.JOptionPane;

import br.com.mcs.beans.Produto;

public class TesteProduto {


public static void main(String[] args) {

		Produto prod = new Produto(1,"Parafuso",1.45f,2.99f);
		JOptionPane.showMessageDialog(null,prod.imprime());

}//Fim do método main

}
