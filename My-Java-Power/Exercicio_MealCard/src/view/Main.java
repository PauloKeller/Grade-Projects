//package view;
//
//import mytuil.MealCard;
//import mytuil.Cardapio;
//import java.util.*;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//
//		int saldo;
//		int opcao;
//		int flag = 1;
//		String nome;
//		
//		Scanner leitor = new Scanner(System.in);
//		
//		System.out.print("Digite o nome do Aluno:");
//		nome = leitor.next();
//
//		System.out.print("Digite o saldo do Aluno:");
//		saldo = leitor.nextInt();
//
//		MealCard aluno1 = new MealCard(nome, saldo);
//		
//		while (flag != 0) {
//			System.out.printf("Nome do aluno:" + aluno1.aluno);
//			System.out.print("\nDigite a opção:");
//			System.out.print("\n1- Salgado");
//			System.out.print("\n2- Sobremesa");
//			System.out.print("\n3- Almoço");
//			System.out.print("\n4- Jantar");
//			System.out.print("\n5- Sorvete");
//			System.out.print("\n0- Finalizar compra");
//			System.out.printf("\nSALDO: %d", aluno1.saldo);
//			
//			opcao = leitor.nextInt();
//			flag = opcao;
//			aluno1.fazerCompra(opcao);
//		
//		}
//
//	}
//	
//}


