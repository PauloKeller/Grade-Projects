package business;

import modelo.*;
import java.util.ArrayList;;

public class Oficina {
	
	public String manutencao(ArrayList<Veiculo> veiculos){
		
		String ret = " ";
		
		for (Veiculo v : veiculos)
		{
			ret += manutencao(v) + " \n";
		}
		
		return ret;
	}
	
	protected String manutencao(Veiculo v)
	{
		String ret = " ";
		
		ret += v.ajustar() + " - ";
		ret += v.limpar() + " - ";
		ret += v.listaVerificacoes();
		
		if(v.getClass().getName().equalsIgnoreCase("modelo.automovel"))
		{
			Automovel a = (Automovel) v;
			
			ret += " - " + a.trocarOleo();
		}
		
		return ret;
	
	}

}
