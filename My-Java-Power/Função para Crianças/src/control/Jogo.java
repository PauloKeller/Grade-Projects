package control;

import java.util.*;
import javax.swing.Timer;

public class Jogo {
	float a, a1, b, b1;
	int erros = 0, acertos = 0, n = 0, segundos=0;
	float soma, subtracao, multiplicacao, divisao;
	float Rsoma, Rsubtracao, Rmultiplicacao, Rdivisao;

	Scanner leitor = new Scanner(System.in);
	Random valores = new Random();
	Timer timer;

	public void jogar() {
		geraEquacao();
		printaResultados();
	}

	public void geraValores() {

		a = valores.nextInt(10);
		a1 = valores.nextInt(10);
		b = valores.nextInt(10);
		b1 = valores.nextInt(10);

	}

	public void geraEquacao() {
		do {
			n++;
			geraValores();
			soma = (a / a1) + (b / b1);
			System.out.println("(" + a + "/" + a1 + ")" + "+" + "(" + b + "/" + b1 + ")");
			System.out.print("Digite a resposta da equação: ");
			Rsoma = leitor.nextFloat();
			confereSoma();
			if (n == 10) {
				break;
			}
			
			pararJogo();
			n++;
			geraValores();
			subtracao = (a / a1) - (b / b1);
			System.out.println("(" + a + "/" + a1 + ")" + "-" + "(" + b + "/" + b1 + ")");
			System.out.print("Digite a resposta da equação: ");
			Rsubtracao = leitor.nextFloat();
			confereSubtracao();
			if (n == 10) {
				break;
			}
			
			pararJogo();
			n++;
			geraValores();
			multiplicacao = (a / a1) * (b / b1);
			System.out.println("(" + a + "/" + a1 + ")" + "*" + "(" + b + "/" + b1 + ")");
			System.out.print("Digite a resposta da equação: ");
			Rmultiplicacao = leitor.nextFloat();
			confereMultiplicao();
			if (n == 10) {
				break;
			}
			
			pararJogo();
			n++;
			geraValores();
			divisao = (a / a1) / (b / b1);
			System.out.println("(" + a + "/" + a1 + ")" + "/" + "(" + b + "/" + b1 + ")");
			System.out.print("Digite a resposta da equação: ");
			Rdivisao = leitor.nextFloat();
			confereDivisao();
			if (n == 10) {
				break;
			}

		} while (n < 10);
	}

	public void confereSoma() {
		if (soma == Rsoma) {
			acertos += 1;
		} else {
			erros += 1;
		}
	}

	public void confereSubtracao() {
		if (subtracao == Rsubtracao) {
			acertos += 1;
		} else {
			erros += 1;
		}
	}

	public void confereMultiplicao() {

		if (multiplicacao == Rmultiplicacao) {
			acertos += 1;
		} else {
			erros += 1;
		}
	}

	public void confereDivisao() {

		if (divisao == Rdivisao) {
			acertos += 1;
		} else {
			erros += 1;
		}
	}

	public void printaResultados() {
		System.out.println("Acertos: " + acertos);
		System.out.println("Erros: " + erros);
	}
	
	public void pararJogo(){
		String jogando;
		System.out.println("Deseja continuar jogando? (SIM/NAO)");
		jogando = leitor.next();
		jogando.toLowerCase();
		switch(jogando){
		case "nao":
			System.exit(0);
		}
		
	}
	
}
