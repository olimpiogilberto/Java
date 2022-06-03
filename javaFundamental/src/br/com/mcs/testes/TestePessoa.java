package br.com.mcs.testes;

import javax.swing.JOptionPane;

import br.com.mcs.beans.Endereco;
import br.com.mcs.beans.Pessoa;

public class TestePessoa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	Endereco end = new Endereco("Rua dos Bobos",35,45728600);
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(3267);
		pessoa.setNome("Gilberto");
		pessoa.setLogradouro(end);      
		

/*end.setCep(123456);
end.setRua("Rua 01");
end.setNumero(123);      */

System.out.println("##############################");
System.out.println("Construtor Padrão");
System.out.println("##############################");
System.out.println("CPF: "+ pessoa.getCpf()+ 
        "\nNome: "+ pessoa.getNome()+
        "\nEndereço: " +end.getRua()+ ", " + end.getNumero()+ " " + end.getCep());

System.out.println("");
//------------------------------------------------------------


Endereco end2 = new Endereco("Rua Bertioga",275,6826200);
Pessoa pessoa2 = new Pessoa(191,"Gilberto",end2);

System.out.println("##############################");
System.out.println("Construtor Alternativo");
System.out.println("##############################");
System.out.println(pessoa2.imprime());
/*System.out.println("CEP: "+ end.getCep()+ 
        "\nRua: "+ end.getRua()+
        "\nNúmero: " +end.getNumero()); */

//JOptionPane.showMessageDialog(null,end.imprime());
	}

	

}
