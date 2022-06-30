/**
 * 
 */
package br.com.mcs.beans;

/**
 * @author Gilberto
 *
 */
public class Corrente extends Conta{
	private float limite;
	
	public Corrente() {
		// TODO Auto-generated constructor stub
	}
	public Corrente(Conta cta,float limite) {
		super(cta.getTitular(),cta.getAgencia(), cta.getNumero(),cta.getDigito(), cta.getSaldo());
		
		this.limite = limite;
	}
	
	@Override
	public String imprime(){
		return "Limite: "+ this.limite + 
		        "\n" + super.imprime();
		}	
	@Override
	public String imprimeCerto(){
		return "Titular:" + super.getTitular().getNome() +
				"\nCPF:" + super.getTitular().getCpf()+
				"\n ------ CONTA  ---------" +
		        "\nAg�ncia: "+ super.getAgencia()+
		         "\nConta: "+ super.getNumero()+ "-"+ this.getDigito()+
		           "\nSaldo: "+ super.getSaldo() + 
		           "\nLimite: " + this.getLimite()+
		           "\n ------ ENDERECO  ---------" +
		           "\n" + super.getTitular().getLogradouro().imprime();
		}	
	public float getLimite() {
		return limite;
	}
	
	public void setLimite(float limite) {
		this.limite = limite;
	}

}
