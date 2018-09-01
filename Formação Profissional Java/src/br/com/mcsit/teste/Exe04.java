package br.com.mcsit.teste;

import javax.swing.JOptionPane;

public class Exe04 {
	public static void main(String args[]){

		int numero;
		numero = Integer.parseInt(JOptionPane.showInputDialog("Valor"));
		String pares = "";
		
		for(int i = 1; i <= numero;i++){
			if(i % 2 == 0) pares += i + " ";
		}
		
		JOptionPane.showMessageDialog(null, "Numeros pares" + pares);  
	}

}
