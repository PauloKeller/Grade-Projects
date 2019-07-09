package view;
import java.util.Scanner;

public class Print {

	public static void main(String[] args) {
		Scanner reader = new java.util.Scanner (System.in);
		System.out.println("Digite o primeiro numero:");
		float n1 = reader.nextInt();
		System.out.println("Digite o segundo numero:");
		float n2 = reader.nextInt();
		System.out.printf("Soma:%.1f Subtração:%.1f Multiplicação:%.1f Divisão:%.13f",n1+n2,n1-n2,n1*n2,n1/n2);
		

	}

}
