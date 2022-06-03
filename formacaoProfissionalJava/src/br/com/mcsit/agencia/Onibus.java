package br.com.mcsit.agencia;

public class Onibus extends Transporte{
	private int poltrona;

	public int getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}
	
	@Override
	public float calculaPreco() {
		return 0;
	}

}
