package br.com.mcsit.ensino;

import br.com.mcsit.basico.Aluno;
import br.com.mcsit.basico.Curso;

public class Matricula extends Aluno{
	private Aluno aluno = new Aluno();
	private Disciplina disciplina;
	private Curso curso;
	
	public Matricula() {
		this.aluno = new Aluno();
		this.disciplina = new Disciplina();
		this.curso = new Curso();
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
	

}
