package control;

import view.*;

public class Aluno {
	public String nome;
	public Clubes clube;
	public int posicao;

	public Aluno(String nome) {
		this.nome = nome;
	}

	public Clubes escolherClube(int valor) {
		switch (valor) {
		case 1:
			clube = Clubes.CLUBE_DA_CIÊNCIA_DA_COMPUTAÇÃO;
			break;
		case 2:
			clube = Clubes.CLUBE_DE_BIOLOGIA;
			break;
		case 3:
			clube = Clubes.CLUBE_DE_BILHAR;
			break;
		case 4:
			clube = Clubes.CLUBE_SEM_SONO;
			break;
		case 5:
			clube = Clubes.CLUBE_DE_DEGUSTAÇÃO_DE_VINHOS;
			break;
		}
		return clube;

	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
}