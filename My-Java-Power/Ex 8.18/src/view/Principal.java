package view;
import java.util.Scanner;

import model.Jogada;
import model.TicTacToe;
public class Principal {

	public static void main(String[] args) {
		
		TicTacToe velha = new TicTacToe();
		
		Scanner leitor = new Scanner(System.in);
		
		int linha = 0;
		int coluna = 0;
		Boolean joga = false;
		
		while(!joga)
		{
			System.out.println("------------------");
			System.out.println("Jogador: " + velha.getProximoJodador());
			System.out.println("--------------------");
			
			
			System.out.print("Entre com a linha desejada:");
			linha = leitor.nextInt()-1;
			
			System.out.print("Entre com a coluna desejada");
			coluna = leitor.nextInt()-1;
			
			if(velha.registraJogada(linha, coluna))
			{
				System.out.println("Jogada invalida. Tente novamente.");
			}
			
			if(velha.verificaGanhador())
			{
				System.out.println("---------------Você Ganhou!!!----------");
				joga = true;
			}
				else if(velha.verificaGanhador() && velha.getEmpate())
				{
					System.out.println("------------VELHA!!----------------");
					joga = true;
				}
			imprimeTabuleiro(velha.getTabuleiro());
		}


	}
	
	public static void imprimeTabuleiro(Jogada[][] tabuleiro)
	{
		System.out.println();
		
		for(int l=0; l<3; l++){
			for(int c=0; c<3; c++){
				if(tabuleiro[l][c] != Jogada.EMPTY)
					System.out.print(tabuleiro[l][c] + " | ");
				else
					System.out.print(" " + " | ");
			}
			
			System.out.println();
		}
	}

}
