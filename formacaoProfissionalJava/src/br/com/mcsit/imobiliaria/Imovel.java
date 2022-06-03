package br.com.mcsit.imobiliaria;

public class Imovel {
	private int codigo;
	private float valor;
	private int area;
	private Endereco endereco;
	private Pessoa proprietario;
	private TipoImovel tipo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Pessoa getProprietario() {
		return proprietario;
	}
	public void setProprietario(Pessoa proprietario) {
		this.proprietario = proprietario;
	}
	public TipoImovel getTipo() {
		return tipo;
	}
	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo;
	}
	

}
