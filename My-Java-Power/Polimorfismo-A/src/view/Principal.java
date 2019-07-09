package view;
import modelo.*;
import business.*;
import java.util.ArrayList;
import java.util.Random;


public class Principal {
	
	public static void main(String[] args){
		
		int i=0;
		
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>(); 
		
		for(;i <= 10; i++)
		{
			veiculos.add(criarVeiculos());
		}
		
		Oficina oficina = new Oficina();
		
		System.out.println(oficina.manutencao(veiculos));
		
	}
	
	private static Veiculo criarVeiculos(){
		
		Random r = new Random();
		
		if( r.nextInt() % 2 == 0 )
		{
			return new Bicicleta();
		}
		
		else
		{
			return new Automovel();
		}
		
	}

}
