package br.com.mcsit.financeiro;

public class Conta extends Produto implements IConta{
	private int agencia;
	private int numero;
	private float saldo;
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	@Override
	public boolean deposito(float valor) {
		this.setSaldo(this.getSaldo()+valor);
		return true;
		
	}
	
	
	@Override
	public boolean saque(float valor) {
		if(this.getSaldo()>= valor){
			this.setSaldo(this.getSaldo()-valor);
			return true;
	}else return false;
	}
	
	@Override
    public boolean transferencia(Conta c, float valor) {
	   if(this.saque(valor)){
		   return c.deposito(valor);
	}else return false;
	}

}
		
			

