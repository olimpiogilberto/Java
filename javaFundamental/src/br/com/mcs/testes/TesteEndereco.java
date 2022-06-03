package br.com.mcs.testes;

import javax.swing.JOptionPane;

import br.com.mcs.beans.Endereco;

public class TesteEndereco {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Endereco end = new Endereco("Rua 02",456,01234567);
/*end.setCep(123456);
end.setRua("Rua 01");
end.setNumero(123);      */

System.out.println(end.imprime());

/*System.out.println("CEP: "+ end.getCep()+ 
        "\nRua: "+ end.getRua()+
        "\nNúmero: " +end.getNumero()); */

JOptionPane.showMessageDialog(null,end.imprime());
	}

	

}
