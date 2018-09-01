package br.com.mcsit.basico;

public class Professor extends Pessoa{
	
	private Integer rgf;
	private String disciplina;
	public Integer getRgf() {
		return rgf;
	}
	public void setRgf(Integer rgf) {
		this.rgf = rgf;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

}
