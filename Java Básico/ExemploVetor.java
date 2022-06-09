/*
 * Array ou vetor em Java.
 *  Em java vetores são objetos e em razão disto necessitam ser declarados e instanciados.
 *  Como nas demais linguagens um vetor é acessado pelo indice, sendo que em java o primeiro índice é ZERO e o último
 *length-1, onde o atributo length armazena a quantidade de elementos do vetor.
 *  Exemplos de declaração
 *  int Vetor[];//tipoDado nomeVetor[];
 *  int Vetor[];//tipoDado nomeVetor[];
 *  Exemplos de instanciação
 *  vetor=new int[qtd];//nomeVetor= new tipoDado[qtd];
 *  Declaração e Instanciação em uma instrução
 *  byte vetor[]= new byte[qtd];//tipoDado nomeVetor= nw tipoDado[qtd]   */

class ExemploVetor 
{
	
		public static void main(String[]ar)
		{
			String nome[]=new String[3];
		
		       nome[0]="Marcos";
		       nome[1]="Paulo";
		       nome[2]="Simone";
		       for(int i=0;i<nome.length;i++)
		       {
		    	   System.out.println(nome[i]);
		    	  
		       }
	}
}
