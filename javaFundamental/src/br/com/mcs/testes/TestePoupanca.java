/**
 * 
 */
package br.com.mcs.testes;

import br.com.mcs.beans.Conta;
import br.com.mcs.beans.Endereco;
import br.com.mcs.beans.Pessoa;
import br.com.mcs.beans.Poupanca;

/**
 * @author Gilberto
 *
 */
public class TestePoupanca {

	
	public TestePoupanca() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endereco end2 = new Endereco("Rua Bertioga",275,6826200);
		Pessoa pessoa2 = new Pessoa(191,"Gilberto",end2);
		
Conta cta = new Conta(pessoa2, 1813,25,0,10);
Poupanca poupanca = new Poupanca(cta,15);

System.out.println("##############################");
System.out.println("Construtor Alternativo");
System.out.println("##############################");
System.out.println(poupanca.imprimeCerto());

//JOptionPane.showMessageDialog(null,end.imprime());
	}

}
