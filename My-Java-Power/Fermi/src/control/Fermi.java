package control;

import java.util.*;

public class Fermi {
	Posicoes resposta;
	int random[] = new int[3];
	int numeros[] = new int[3];
	int confere1[] = new int[3];
	int confere2[] = new int[3];
	int confere3[] = new int[3];
	Scanner leitor = new Scanner(System.in);

	Random valores = new Random();

	public void geraAleatorio() {
		for (int i = 0; i < 3; i++) {
			random[i] = valores.nextInt(10);
		}

		for (int l = 0; l < 3; l++) {
			System.out.println(random[l]);
		}
		mostraValores();
		Compara();
	}

	public void mostraValores() {

		for (int n = 0; n < 3; n++) {
			System.out.println("\nDigite o numero : ");
			numeros[n] = leitor.nextInt();
		}
	}

	public void Compara() {
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		for (int k = 0; k < 3; k++) {
			if (numeros[0] == random[k]) {
				confere1[k] = 1;
				n1++;
				break;
			}
			if (numeros[1] == random[k]) {
				confere2[k] = 1;
				n2++;
				break;
			}
			if (numeros[2] == random[k]) {
				confere3[k] = 1;
				n3++;
				break;
			}
		}
		printaVetor(n1, n2, n3);
	}

	public void printaVetor(int n1, int n2, int n3) {
			if(n1>0){
				if(numeros[confere1[0]] == random[0]){
					System.out.print("Fermi");
				}
				else{
					System.out.print("Pico");
				}
			}
			
			if(n2>0){
				if(numeros[confere2[1]] == random[1]){
					System.out.print("Fermi");
				}
				else{
					System.out.print("Pico");
				}
			}
			if(n3>0){
				if(numeros[confere3[2]] == random[2]){
					System.out.print("Fermi");
				}
				else{
					System.out.print("Pico");
				}
			}
		System.out.println();
		for (int k = 0; k < 3; k++) {
			System.out.print(confere1[k]);
		}
		System.out.println();
		for (int l = 0; l < 3; l++) {
			System.out.print(confere2[l]);
		}
		System.out.println();
		for (int m = 0; m < 3; m++) {
			System.out.print(confere3[m]);
		}
	}
}