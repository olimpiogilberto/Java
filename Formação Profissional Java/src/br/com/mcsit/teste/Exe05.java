package br.com.mcsit.teste;

import javax.swing.JOptionPane;

public class Exe05 {

	public static void main(String args[]){

		int oper = Integer.parseInt(JOptionPane.showInputDialog("Operacoes\n\n" +
				"1 - Adi��o\n" +
				"2 - Subtra��o\n" +
				"3 - Multiplica��o\n" +
				"4 - Divis�o\n" +
				"5 - Resto da Divis�o\n" +
				"6 - Pot�ncia"));


		
			if(oper>=1 && oper <= 6) {
			   float n1 = Float.parseFloat(JOptionPane.showInputDialog("N�mero 1:"));
			   float n2 = Float.parseFloat(JOptionPane.showInputDialog("N�mero 2:"));
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


