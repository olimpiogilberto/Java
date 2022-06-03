/**
 * 
 */
package br.com.mcs.testes;

import br.com.mcs.beans.Aluno;
import br.com.mcs.beans.Conta;
import br.com.mcs.beans.Endereco;
import br.com.mcs.beans.Pessoa;

/**
 * @author Gilberto
 *
 */
public class TesteConta {

	/**
	 * 
	 */
	public TesteConta() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endereco end2 = new Endereco("Rua Bertioga",275,6826200);
		Pessoa pessoa2 = new Pessoa(191,"Gilberto",end2);
		
Conta cta = new Conta(pessoa2, 1813,25,0,10);

System.out.println("##############################");
System.out.println("Construtor Alternativo");
System.out.println("##############################");
System.out.println(cta.imprimeCerto());

//JOptionPane.showMessageDialog(null,end.imprime());
	}

}
