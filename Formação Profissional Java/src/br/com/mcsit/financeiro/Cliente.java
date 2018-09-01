package br.com.mcsit.financeiro;

import br.com.mcsit.basico.Pessoa;

public class Cliente extends Pessoa{
	private int codigo;
	private int contrato;
	private Produto produto;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getContrato() {
		return contrato;
	}
	public void setContrato(int contrato) {
		this.contrato = contrato;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	

}
