package view;

import model.Flight;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		
		System.out.println("++++++++++Air Traffic Control Simulator++++++++++");
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("++++++++++Dados do voo numero 1:++++++++++");
		
		Flight voo1 = new Flight(0, null, null, null, null, null, 0, 0);

		System.out.println("++++++++++Dados do voo numero 2:++++++++++");
		
		Flight voo2 = new Flight(0, null, null, null, null, null, 0, 0);
		
		System.out.println("++++++++++Dados do voo numero 3:++++++++++");
		
		Flight voo3 = new Flight(0, null, null, null, null, null, 0, 0);
		
		int aviao = 0;
		int opcao = 0;
		boolean fim_de_voo = false;
		boolean seleciona = false;
		
		while(!fim_de_voo){
			
			System.out.print("Secione o voo:");
			aviao = leitor.nextInt();
			
			if (aviao == 1 )
				while(!seleciona){
					
					System.out.println("--------------------------------");
					System.out.println("-------------OPÇÕES-------------");
					System.out.println("1- ESTACIONADO");
					System.out.println("2- TAXEANDO ANTES DE DECOLAR");
					System.out.println("3- TAXEANDO APOS POUSAR");
					System.out.println("4- ESPERANDO PARA POUSAR");
					System.out.println("5- DECOLANDO");
					System.out.println("6- SUBINDO");
					System.out.println("7- VELOCIDADE ATUAL");
					System.out.println("8- VOLTAR MENU");
					System.out.println("9- FINALIZAR VOO");
					System.out.println("--------------------------------");
					System.out.print("Opção:");
					
					opcao = leitor.nextInt();
					
					if(opcao == 1){
						voo1.changeEstacionado();
						
						continue;
					}
					else if(opcao == 2){
						voo1.changeTaxeando_antes_de_decolar();
						
						continue;
					}
					else if(opcao == 3){
						voo1.changeTaxeando_apos_pousar();
						
						continue;
					}
					else if(opcao == 4){
						voo1.changeEsperando_para_pousar();
						
						continue;
					}
					else if(opcao == 5){
						voo1.changeDecolando();
						
						continue;
					}
					else if(opcao == 6){
						voo1.changeSubindo();
						
						continue;
					}
					else if(opcao == 7){
						voo1.changeVelocidade_atual();
						
						continue;
					}
					else if(opcao == 8){
						voo1.changeAltitude_atual();
						
						continue;
					}
					else if(opcao == 9){
						break;
					}
					else if(opcao == 10){
						fim_de_voo = true;
						
						break;
					}
						
				}
			
			if(aviao == 2)
				while(!seleciona){
					
					System.out.println("--------------------------------");
					System.out.println("-------------OPÇÕES-------------");
					System.out.println("1- ESTACIONADO");
					System.out.println("2- TAXEANDO ANTES DE DECOLAR");
					System.out.println("3- TAXEANDO APOS POUSAR");
					System.out.println("4- ESPERANDO PARA POUSAR");
					System.out.println("5- DECOLANDO");
					System.out.println("6- SUBINDO");
					System.out.println("7- VELOCIDADE ATUAL");
					System.out.println("8- VOLTAR MENU");
					System.out.println("9- FINALIZAR VOO");
					System.out.println("--------------------------------");
					System.out.print("Opção:");
					opcao = leitor.nextInt();
					
					if(opcao == 1){
						voo2.changeEstacionado();
						
						continue;
					}
					else if(opcao == 2){
						voo2.changeTaxeando_antes_de_decolar();
						
						continue;
					}
					else if(opcao == 3){
						voo2.changeTaxeando_apos_pousar();
						
						continue;
					}
					else if(opcao == 4){
						voo2.changeEsperando_para_pousar();
						
						continue;
					}
					else if(opcao == 5){
						voo2.changeDecolando();
						
						continue;
					}
					else if(opcao == 6){
						voo2.changeSubindo();
						
						continue;
					}
					else if(
							opcao == 7){
						voo2.changeVelocidade_atual();
						
						continue;
					}
					else if(opcao == 8){
						voo2.changeAltitude_atual();
						
						continue;
					}
					else if(opcao == 9){
						break;
					}
					else if(opcao == 10){
						fim_de_voo = true;
						
						break;
					}

				}
			
			if(aviao == 3)
				while(!seleciona){
					
					System.out.println("--------------------------------");
					System.out.println("-------------OPÇÕES-------------");
					System.out.println("1- ESTACIONADO");
					System.out.println("2- TAXEANDO ANTES DE DECOLAR");
					System.out.println("3- TAXEANDO APOS POUSAR");
					System.out.println("4- ESPERANDO PARA POUSAR");
					System.out.println("5- DECOLANDO");
					System.out.println("6- SUBINDO");
					System.out.println("7- VELOCIDADE ATUAL");
					System.out.println("8- VOLTAR MENU");
					System.out.println("9- FINALIZAR VOO");
					System.out.println("--------------------------------");
					System.out.print("Opção:");
					opcao = leitor.nextInt();
					
					if(opcao == 1){
						voo3.changeEstacionado();
						
						continue;
					}
					else if(opcao == 2){
						voo3.changeTaxeando_antes_de_decolar();
						
						continue;
					}
					else if(opcao == 3){
						voo3.changeTaxeando_apos_pousar();
						
						continue;
					}
					else if(opcao == 4){
						voo3.changeEsperando_para_pousar();
						
						continue;
					}
					else if(opcao == 5){
						voo3.changeDecolando();
						
						continue;
					}
					else if(opcao == 6){
						voo3.changeSubindo();
						
						continue;
					}
					else if(opcao == 7){
						voo3.changeVelocidade_atual();
						
						continue;
					}
					else if(opcao == 8){
						voo3.changeAltitude_atual();
						
						continue;
					}
					else if(opcao == 9){
						break;
					}
					else if(opcao == 10){
						fim_de_voo = true;
						
						break;
					}

				}
		}
		
	}

}
