package view;
import java.util.Scanner;

public class Print {

	public static void main(String[] args) {
		float aux = 0;
		int maior = 0;
		int menor = 0;
		Scanner reader = new java.util.Scanner(System.in);
		System.out.println("Digite o primeiro numero:");
		int n1 = reader.nextInt();
		System.out.println("Digite o segundo numero:");
		int n2 = reader.nextInt();
		if (n1 > n2){
			maior = n1;
			menor = n2;
		}
		else{
			maior = n2;
			menor = n1;
		}
		aux = n1+n2/2;
		System.out.printf("Soma:%d",n1+n2);
		System.out.printf("Média:%.1f",aux);
		System.out.printf("Maior:%d Menor:%d",maior,menor);

	}

}
