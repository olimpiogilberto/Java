package br.com.mcsit.teste;

import javax.swing.JOptionPane;

public class Exe05 {

	public static void main(String args[]){

		int oper = Integer.parseInt(JOptionPane.showInputDialog("Operacoes\n\n" +
				"1 - Adição\n" +
				"2 - Subtração\n" +
				"3 - Multiplicação\n" +
				"4 - Divisão\n" +
				"5 - Resto da Divisão\n" +
				"6 - Potência"));


		
			if(oper>=1 && oper <= 6) {
			   float n1 = Float.parseFloat(JOptionPane.showInputDialog("Número 1:"));
			   float n2 = Float.parseFloat(JOptionPane.showInputDialog("Número 2:"));
			   float resultado = 0;
			   
			   switch (oper){
			   case 1:
				   resultado = n1 + n2;
				   break;
			   case 2:
				   resultado = n1 - n2;
				   break;
			   case 3:
				   resultado = n1 * n2;
				   break;
			   case 4:
				   resultado = n1 / n2;
				   break;
			   case 5:
				   resultado = n1 % n2;
				   break;
			   case 6:
				   resultado = (float)Math.pow(n1, n2);
				   break;
			   
			   }
			   JOptionPane.showMessageDialog(null, "" + resultado);}
			   else{
				   JOptionPane.showMessageDialog(null, ""); 
				   }
			 
			   }
				
					
		
	}


