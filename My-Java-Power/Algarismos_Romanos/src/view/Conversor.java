package view;

import java.util.*;

public class Conversor {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		int valor;
		int n;
		int sobra = 0;
		String romano = "";

		System.out.print("Digite um numero entre 1 e 3999:");
		valor = leitor.nextInt();

		n = valor;

		if (valor < 4000) {
			while (valor >= 1000) {
				romano += "M";
				valor -= 1000;
			}

			while (valor >= 900) {
				romano += "CM";
				valor -= 900;
			}

			while (valor >= 500) {
				romano += "D";
				valor -= 500;
			}

			while (valor >= 400) {
				romano += "CD";
				valor -= 400;
			}

			while (valor >= 100) {
				romano += "C";
				valor -= 100;
			}

			while (valor >= 90) {
				romano += "XC";
				valor -= 90;
			}

			while (valor >= 50) {
				romano += "L";
				valor -= 50;
			}

			while (valor >= 40) {
				romano += "XL";
				valor -= 40;
			}

			while (valor >= 10) {
				romano += "X";
				valor -= 10;
			}

			while (valor >= 9) {
				romano += "IX";
				valor -= 9;
			}

			while (valor >= 5) {
				romano += "V";
				valor -= 5;
			}

			while (valor >= 4) {
				romano += "IV";
				valor -= 4;
			}

			while (valor >= 1) {
				romano += "I";
				valor -= 1;
			}
			System.out.println("O numero " + n + " em algarismo romano é " + romano);
		} else {
			System.out.print("Valor Inválido!");
		}
	}

}
