package model;

public class Professor extends Pessoa{
	public int n_matricula;
	public String[] turmas;

	public Professor(String nome, int n_matricula){
		super(nome);
		this.n_matricula = n_matricula;

	}
	
	public void setDisciplinas(String[] turmas){
		this.turmas = turmas;
	}

}
