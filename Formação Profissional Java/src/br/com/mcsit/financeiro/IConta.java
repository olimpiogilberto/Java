package br.com.mcsit.financeiro;

public interface IConta {
	public boolean deposito(float valor);
	public boolean saque(float valor);
	public boolean transferencia(Conta c,float valor);

}
