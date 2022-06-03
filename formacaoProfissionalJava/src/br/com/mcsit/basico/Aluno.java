package br.com.mcsit.basico;

public class Aluno extends Pessoa{
	private Integer ra = 0;
	private Curso curso = new Curso();
	private Controle controle = new Controle();
	public Integer getRa() {
		return ra;
	}
	public void setRa(Integer ra) {
		this.ra = ra;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Controle getControle() {
		return controle;
	}
	public void setControle(Controle controle) {
		this.controle = controle;
	}
}
