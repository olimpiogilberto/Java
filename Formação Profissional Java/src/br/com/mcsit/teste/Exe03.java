package br.com.mcsit.teste;

import java.util.Date;

import javax.swing.JOptionPane;

public class Exe03 {


	public static void main(String args[]){
		String sexo;
		int ano=1;
		Date dataAtual = new Date();
		@SuppressWarnings("deprecation")
		int anoAtual = dataAtual.getYear()+1900;
		int idade;
		do{
			try{
			ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do seu nascimento"));
			if(ano != 0){
			   if(anoAtual - ano<1 || anoAtual - ano>113){
				
				JOptionPane.showMessageDialog(null, "Data inválida, tente outra vez!");	
			   }else{
				  idade = anoAtual - ano;	
				   sexo = JOptionPane.showInputDialog("Digite seu sexo: \n M - Masculino \n F - Feminino");
				   int s = sexo(sexo);
				   if(s>2){
					JOptionPane.showMessageDialog(null, "Sexo inválido, tente outra vez!");   
				   }else{
					   retorno(s, idade);  
				   }			 
			 
			  }
			}else{JOptionPane.showMessageDialog(null,"Encerrando...");}
			}
			catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "Sexo inválido, tente outra vez!");
			}
			
		  }while(ano != 0);
	}
	
 //medo sexo	
public static int sexo(String a){
	if(a.equals("F")||a.equals("f")){
		return 1;
	}else if(a.equals("M")||a.equals("m")){
		return 2;
	}else{
		return 3;
	}
 
 
	} 

//medo retorno	
public static void retorno(int a, int b){
	if(a ==1 ){
		  if(b >=21){
		  JOptionPane.showMessageDialog(null, "Mulher adulta");
		  }
		  else{JOptionPane.showMessageDialog(null, "Você é só uma menina");
		  }
		  
	}else
	{ if( b>=18){
          JOptionPane.showMessageDialog(null, "Homem adulto");
          }else{ JOptionPane.showMessageDialog(null, "Você é só um menino");}
     
          }
}
	
	
}
	


