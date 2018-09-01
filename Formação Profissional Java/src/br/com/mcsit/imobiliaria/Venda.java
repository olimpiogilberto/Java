package br.com.mcsit.imobiliaria;

public class Venda {
	private int codigo;
	private Corretor corretor;
	private Imovel imovel;
	private Pessoa comprador;
	private float valor;
	private float comissao;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Corretor getCorretor() {
		return corretor;
	}
	public void setCorretor(Corretor corretor) {
		this.corretor = corretor;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public Pessoa getComprador() {
		return comprador;
	}
	public void setComprador(Pessoa comprador) {
		this.comprador = comprador;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	
}
