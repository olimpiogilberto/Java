package br.com.mcsit.teste;

import javax.swing.JOptionPane;

public class Exemplo {
	public static void main(String args[]){
		int valor;
	
		do{
			valor = Integer.parseInt(JOptionPane.showInputDialog("Valor"));
			String tabuada = "";
			if(valor != 0){
				
				for(int i =1;i<=10;i++){
					int resultado = i*valor;
					tabuada += i + " x " + valor + " = " + resultado + "\n ";
				}
				
				JOptionPane.showMessageDialog(null, tabuada);
			}else{
				JOptionPane.showMessageDialog(null,"Encerrando...");
			}
			
		}while(valor != 0);
	}
}


