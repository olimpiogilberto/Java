package br.com.mcs.testes;

import br.com.mcs.beans.Exame;

public class TesteExame {

public static void main(String[] args) {
		
	Exame exame = new Exame(1,"Exame de Vista", "OK","OK");
	System.out.println(exame.imprime());

	}

}
