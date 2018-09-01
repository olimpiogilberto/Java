package br.com.mcsit.agencia;

public class Navio extends Transporte{
	private int cabine;

	public int getCabine() {
		return cabine;
	}

	public void setCabine(int cabine) {
		this.cabine = cabine;
	}
	
	@Override
	public float calculaPreco() {
		// TODO Auto-generated method stub
		return 0;
	}
}
