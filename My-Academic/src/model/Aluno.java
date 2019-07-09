package model;

public class Aluno {
	
	int id;
	String email;
	String senha;
	String nome;
	String cpf;
	Faculdade faculdade;
	Curso curso;
	
	public Aluno(int id, String email, String senha, String nome, String cpf, Faculdade faculdade, Curso curso) {
		this.nome = nome;
		this.cpf = cpf;
		this.id = id;
		this.senha = senha;
		this.email = email;
		this.curso = curso;
		this.faculdade = faculdade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Faculdade getFaculdade() {
		return faculdade;
	}
	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}	
}
