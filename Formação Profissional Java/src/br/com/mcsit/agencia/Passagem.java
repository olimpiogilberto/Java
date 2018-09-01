package br.com.mcsit.agencia;

import java.util.List;

public class Passagem implements IVendas{
	
	private int codigo;
	private Cliente cliente;
	private Produto produto;
	private Horario horario;
	private List<Trajeto> trajetos;
	private List<Transporte> transporte;
    private float preco;

	@Override
	public boolean validaGrupos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean compraPassagem() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public List<Trajeto> getTrajetos() {
		return trajetos;
	}

	public void setTrajetos(List<Trajeto> trajetos) {
		this.trajetos = trajetos;
	}

	public List<Transporte> getTransporte() {
		return transporte;
	}

	public void setTransporte(List<Transporte> transporte) {
		this.transporte = transporte;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


}
