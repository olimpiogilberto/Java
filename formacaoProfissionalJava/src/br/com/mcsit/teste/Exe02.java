package br.com.mcsit.teste;

import java.util.Date;

import javax.swing.JOptionPane;

public class Exe02 {

	public static void main(String args[]){
		int ano;
		Date dataAtual = new Date();
		@SuppressWarnings("deprecation")
		int anoAtual = dataAtual.getYear()+1900;
		int idade;
		do{
			ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do seu nascimento"));
			if(ano != 0){
			if(anoAtual - ano<1 || anoAtual - ano>113){
				
				JOptionPane.showMessageDialog(null, "Data inválida, tente outra vez!");	
			}else{
				idade = anoAtual - ano;
				JOptionPane.showMessageDialog(null, "Sua idade é "+idade);
			}
			}else{
				JOptionPane.showMessageDialog(null,"Encerrando...");
			}
		}while(ano != 0);
	}
}
