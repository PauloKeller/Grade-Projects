package view;

import model.Estatistica;
import java.util.*;

public class Client {
	public static void main(String[] args) {
		
		int valor;
		Estatistica e = new Estatistica();
		int n=0;
		Scanner leitor = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de valores:");


		double array[];
		n = leitor.nextInt();
		
		array = new double[n];
		for(int i=0; i<n; i++){ 
			array[i] = valor = leitor.nextInt();
		}


		e.setArray(array);

		double t1 = System.currentTimeMillis();

		System.out.print("\n Desvio Padrão: " + e.getDesvioPadrao());

		double t2 = System.currentTimeMillis();

	}

}
