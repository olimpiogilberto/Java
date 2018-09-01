package br.com.mcsit.basico;

public class Professor extends Pessoa{
	
	private Integer rgf;
	private Disciplina disciplina = new Disciplina();
	public Integer getRgf() {
		return rgf;
	}
	public void setRgf(Integer rgf) {
		this.rgf = rgf;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
