/**
 * 
 */
package br.com.mcs.beans;


/**
 * @author Gilberto
 *
 */
public class Poupanca extends Conta{

	private Integer aniversario;
	
	public Integer getAniversario() {
		return aniversario;
	}
	public void setAniversario(Integer aniversario) {
		this.aniversario = aniversario;
	}
	public Poupanca() {
		// TODO Auto-generated constructor stub
	}

	public Poupanca(Conta cta,Integer aniversario) {
		super(cta.getTitular(),cta.getAgencia(), cta.getNumero(),cta.getDigito(), cta.getSaldo());
		
		this.aniversario = aniversario;
	}
	public String imprime(){
		return "Aniversário: "+ this.aniversario + 
		        "\n" + super.imprime();
		}	
	public String imprimeCerto(){
		return "Titular:" + super.getTitular().getNome() +
				"\nCPF:" + super.getTitular().getCpf()+
				"\n ------ CONTA  ---------" +
		        "\nAgência: "+ super.getAgencia()+
		         "\nConta: "+ super.getNumero()+ "-"+ this.getDigito()+
		           "\nSaldo: "+ super.getSaldo() + 
		           "\nRemuneração: " + this.getAniversario()+
		           "\n ------ ENDERECO  ---------" +
		           "\n" + super.getTitular().getLogradouro().imprime();
		}	
}
