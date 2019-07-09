package model;

public class Aluno extends Pessoa {
	public int n_matricula;
	public String turma;
	
	public Aluno(String nome, int n_matricula, String turma){
		super (nome);
		this.n_matricula = n_matricula;
		this.turma = turma;
		
	}

}
