package view;
import java.util.Scanner;

public class Print {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Digite o primeiro numero:");
		int n1 = reader.nextInt();
		System.out.println("Digite o segundo numero");
		int n2 = reader.nextInt();
		if(n1/n2 == 0)
			System.out.println("Numero 1 é Multiplo de Numero 2!");
		else
			System.out.println("Numero 1 não é Multiplo de Numero 2!");
	}
}
