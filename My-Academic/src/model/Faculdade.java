package model;

public class Faculdade {
	
	private String nome;
	private String sigla;
	private String endereco;
	private int telefone;
	private String site;
	
	public Faculdade(String nome, String sigla, String endereco, int telefone, String site){
		this.nome = nome;
		this.sigla = sigla;
		this.endereco = endereco;
		this.telefone = telefone;
		this.site = site;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
}
