package view;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner reader = new java.util.Scanner(System.in);
		boolean executar = true;
		while(executar){
			System.out.println("Calculadora basica:");
			System.out.println("Digite a opção desejada:");
			System.out.println("1-SOMA");
			System.out.println("2-SUBTRAÇÃO");
			System.out.println("3-MULTIPLICAÇÃO");
			System.out.println("4-DIVISÃO");
			System.out.println("5-SAIR");
			int opcao = reader.nextInt();
			if(opcao == 1){
				System.out.println("Digite o primeiro numero");
				int n1 = reader.nextInt();
				System.out.println("Digite o segundo numero");
				int n2 = reader.nextInt();
				System.out.printf("Resultado: %d\n",n1+n2);
			}
			else if(opcao == 2){
				System.out.println("Digite o primeiro numero");
				int n1 = reader.nextInt();
				System.out.println("Digite o segundo numero");
				int n2 = reader.nextInt();
				System.out.printf("Resultado: %d\n",n1-n2);
			}
			else if(opcao == 3){
				System.out.println("Digite o primeiro numero");
				int n1 = reader.nextInt();
				System.out.println("Digite o segundo numero");
				int n2 = reader.nextInt();
				System.out.printf("Resultado: %\n",n1*n2);
			}
			else if(opcao == 4){
				System.out.println("Digite o primeiro numero");
				int n1 = reader.nextInt();
				System.out.println("Digite o segundo numero");
				int n2 = reader.nextInt();
				System.out.printf("Resultado: %d\n",n1/n2);
			}
			if(opcao == 5)
				executar = false;
		}
	}

}
