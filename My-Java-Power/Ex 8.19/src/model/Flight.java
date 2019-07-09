package model;

import java.util.Scanner;

public class Flight {
	
		private FlightStatus estacionado;
		private FlightStatus taxeando_antes_de_decolar;
		private FlightStatus taxeando_apos_pousar;
		private FlightStatus esperando_para_decolar;
		private FlightStatus decolando;
		private FlightStatus subindo;
		
		private float hora_de_partida;
		private float hora_de_chegada;
		private float velocidade_atual;
		private float altitude_atual;
		
		private int  fabricacao;
		
		private String modelo;
		private String direcao;
		private String transportadora;
		private String origem;
		private String destino;
		Scanner leitor = new Scanner(System.in);
	 
		public Flight(int fab, String mdl, String transp, String direc,
				String ori, String des, float hdpart, float hdchegada)
		{	
			fabricacao = fab;
			modelo = mdl;
			transportadora = transp;
			direcao = direc;
			origem = ori;
			destino = des;
			hora_de_partida = hdpart;
			hora_de_chegada = hdchegada;
			inicioDeVoo();
		}
		
		public void  inicioDeVoo()
		{
			System.out.println("Digite a data de fabricação:");
			fabricacao = leitor.nextInt();
			System.out.println("Digite o modelo do avião:");
			modelo = leitor.next();
			System.out.println("Digite a transportadora:");
			transportadora = leitor.next();
			System.out.println("Digite a direção do voo:");
			direcao = leitor.next();
			System.out.println("Digite a origem do voo:");
			origem = leitor.next();
			System.out.println("Digite o destino do voo:");
			destino = leitor.next();
			System.out.println("Digite a hora de partida do voo:");
			hora_de_partida = leitor.nextFloat();
			System.out.println("Digite a hora de chegada do voo:");
			hora_de_chegada = leitor.nextFloat();
			System.out.println("Digite o local de origem:");
			estacionado = FlightStatus.YES;
			taxeando_antes_de_decolar = FlightStatus.NO;
			taxeando_apos_pousar = FlightStatus.NO;
			esperando_para_decolar = FlightStatus.YES;
			decolando = FlightStatus.NO;
			subindo = FlightStatus.NO;
			velocidade_atual = 0;
			altitude_atual = 0;			
		}
		
		public void changeEstacionado()
		{
			if (estacionado == FlightStatus.YES){
				estacionado = FlightStatus.NO;
			}
			else
				estacionado = FlightStatus.YES;
			
			System.out.println("FlightStatus 'estacionado' changed");
			
			if (estacionado == FlightStatus.YES){
				System.out.println("FlightStatus anterior" + "" + FlightStatus.YES + "" 
									+ "FlightStatus atual" + "" + FlightStatus.NO);
			}
			else
				System.out.println("FlightStatus anterior" + "" + FlightStatus.NO + "" 
								+ "FlightStatus atual" + "" + FlightStatus.YES);
		}
		
		public void changeTaxeando_antes_de_decolar()
		{
			if (taxeando_antes_de_decolar == FlightStatus.YES){
				taxeando_antes_de_decolar = FlightStatus.NO;
			}
			else
				taxeando_antes_de_decolar = FlightStatus.YES;
			
			System.out.println("FlightStatus 'taxeando antes de decolar' changed");
			
			if (taxeando_antes_de_decolar == FlightStatus.YES){
				System.out.println("FlightStatus anterior" + "" + FlightStatus.YES + "" +"FlightStatus atual" + "" + FlightStatus.NO);
			}
			else
				System.out.println("FlightStatus anterior" + "" + FlightStatus.NO + "" +"FlightStatus atual" + "" + FlightStatus.YES);
		}
		
		public void changeTaxeando_apos_pousar()
		{
		if (taxeando_apos_pousar == FlightStatus.YES){
			taxeando_apos_pousar = FlightStatus.NO;
		}
		else
			taxeando_apos_pousar = FlightStatus.YES;
		
		System.out.println("FlightStatus 'taxeando apos pousar' changed");
		
		if (taxeando_apos_pousar == FlightStatus.YES){
			System.out.println("FlightStatus anterior" + "" + FlightStatus.YES + "" +"FlightStatus atual" + "" + FlightStatus.NO);
		}
		else
			System.out.println("FlightStatus anterior" + "" + FlightStatus.NO + "" +"FlightStatus atual" + "" + FlightStatus.YES);
		}
		
		public void changeEsperando_para_pousar()
		{
			if (esperando_para_decolar == FlightStatus.YES){
				esperando_para_decolar = FlightStatus.NO;
			}
			else
				esperando_para_decolar = FlightStatus.YES;
			
			System.out.println("FlightStatus 'esperando para decolar' changed");
			
			if (esperando_para_decolar == FlightStatus.YES){
				System.out.println("FlightStatus anterior" + "" + FlightStatus.YES + "" +"FlightStatus atual" + "" + FlightStatus.NO);
			}
			else
				System.out.println("FlightStatus anterior" + "" + FlightStatus.NO + "" +"FlightStatus atual" + "" + FlightStatus.YES);
		}
		
		public void changeDecolando()
		{
			if (decolando == FlightStatus.YES){
				decolando = FlightStatus.NO;
			}
			else
				decolando = FlightStatus.YES;
			
			System.out.println("FlightStatus 'decolando' changed");
			
			if (decolando == FlightStatus.YES){
				System.out.println("FlightStatus anterior" + "" + FlightStatus.YES + "" +"FlightStatus atual" + "" + FlightStatus.NO);
			}
			else
				System.out.println("FlightStatus anterior" + "" + FlightStatus.NO + "" +"FlightStatus atual" + "" + FlightStatus.YES);
		}
		
		public void changeSubindo()
		{
			if (subindo == FlightStatus.YES){
				subindo = FlightStatus.NO;
			}
			else
				subindo = FlightStatus.YES;
			
			System.out.println("FlightStatus 'subindo' changed");
			
			if (subindo == FlightStatus.YES){
				System.out.println("FlightStatus anterior" + "" + FlightStatus.YES+""+"FlightStatus atual" + "" + FlightStatus.NO);
			}
			else
				System.out.println("FlightStatus anterior" + "" + FlightStatus.NO+""+"FlightStatus atual" + "" + FlightStatus.YES);
		}
		
		public void changeVelocidade_atual()
		{
			float vatual = velocidade_atual;
			
			System.out.println("Entre com a velocidade:");
			
			velocidade_atual = leitor.nextFloat();
			
			System.out.println("FlightStatus 'velocidade atual' changed");
			System.out.println("Velocidade anterio =" + "" + vatual + "Velocidade Atual =" + "" + velocidade_atual);
		}
		
		public void changeAltitude_atual()
		{
			float aatual  = altitude_atual;
			
			System.out.println("Entre com altitude:");
			
			altitude_atual= leitor.nextFloat();
			
			System.out.println("FlightStatus 'altitude atual' changed");
			System.out.println("Velocidade anterio =" + "" + aatual + "Velocidade Atual =" + "" + altitude_atual);
		}
		
}
