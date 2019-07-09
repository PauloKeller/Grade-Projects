package model;

public class Curso {
	private String nome;
	private int duracao;
	private int numeroMaterias;
	private double horasExtracurriculares;
	
	public Curso(String nome, int duracao, int numeroMaterias, double horasExtracurriculares){
		this.nome = nome;
		this.duracao = duracao;
		this.numeroMaterias = numeroMaterias;
		this.horasExtracurriculares = horasExtracurriculares;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public int getNumeroMaterias() {
		return numeroMaterias;
	}
	public void setNumeroMaterias(int numeroMaterias) {
		this.numeroMaterias = numeroMaterias;
	}
	public double getHorasExtracurriculares() {
		return horasExtracurriculares;
	}
	public void setHorasExtracurriculares(double horasExtracurriculares) {
		this.horasExtracurriculares = horasExtracurriculares;
	}
}
