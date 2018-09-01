package br.com.mcsit.agencia;

import java.util.List;

public class Grupo extends Cliente{
	private Pessoa responsavel;
	private List<Pessoa> integrantes;
	/**
	 * @return the responsavel
	 */
	public Pessoa getResponsavel() {
		return responsavel;
	}
	/**
	 * @param responsavel the responsavel to set
	 */
	public void setResponsavel(Pessoa responsavel) {
		this.responsavel = responsavel;
	}
	/**
	 * @return the integrantes
	 */
	public List<Pessoa> getIntegrantes() {
		return integrantes;
	}
	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<Pessoa> integrantes) {
		this.integrantes = integrantes;
	}

}
