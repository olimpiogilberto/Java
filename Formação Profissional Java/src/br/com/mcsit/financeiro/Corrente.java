package br.com.mcsit.financeiro;

public class Corrente extends Conta{
	private float limite;

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	public boolean saque(float valor) {
		if(this.getSaldo()+this.getLimite()>= valor){
			this.setSaldo(this.getSaldo()-valor);
			return true;
		}else return false;
		}

}
