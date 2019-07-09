package view;

import control.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		String nome;
		int valor;
		int posicao;
		boolean continuar = true;
		String escolha;
		String escolha1;
		Aluno[] dormitorios;
		int i = 0;
		dormitorios = new Aluno[10];

		Scanner leitor = new Scanner(System.in);

		while (continuar) {

			System.out.println("-----DESEJA CADASTRAR OU EXCLUIR ALUNO?");
			System.out.println("-----(EXCLUIR/CADASTRAR/NAO)-------------------------");
			escolha = leitor.next();
			escolha.toLowerCase();

			switch (escolha) {

			case "cadastrar":
				boolean continuar1 = true;
				while (continuar1) {

					System.out.print("Nome do aluno:");
					nome = leitor.next();

					System.out.println("------------------------------------------");
					System.out.println("-----Nº DE VAGAS: "+(10-i)+"--------------");
					System.out.println("-----ESCOLHA O CLUBE----------------------");
					System.out.println("-----1.CLUBE_DA_CIÊNCIA_DA_COMPUTAÇÃO-----");
					System.out.println("-----2.CLUBE_DE_BIOLOGIA -----------------");
					System.out.println("-----3.CLUBE_DE_BILHAR--------------------");
					System.out.println("-----4.CLUBE_SEM_SONO---------------------");
					System.out.println("-----5.CLUBE_DE_DEGUSTAÇÃO_DE_VINHOS------");
					System.out.println("------------------------------------------");
					valor = leitor.nextInt();

					dormitorios[i] = new Aluno(nome);
					dormitorios[i].escolherClube(valor);
					continuar1 = false;
					System.out.println(dormitorios[i].nome);
					System.out.println(dormitorios[i].clube);

					i++;
				}
				break;
			case "excluir":
				System.out.println("------------------------------------------");
				for (int k = 0; k < i; k++) {
					System.out.println(k+ " " + dormitorios[k].nome);
				}
				posicao = leitor.nextInt();
				dormitorios[posicao] = null;
				for (int k = 0; k < posicao; k++) {
					System.out.println(dormitorios[k].nome);
					System.out.println(dormitorios[k].clube);
				}
			case "nao":
				continuar = false;
				break;
			}
		}
		
	}

}
