package modelo;

public class Bicicleta implements Veiculo {
	
	@Override
	public String ajustar(){
		return "Método ajustar da classe bicicleta";
	}
	
	@Override
	public String listaVerificacoes(){
		return "Método lista verificações da classe bicicleta";
	}
	
	@Override
	public String limpar(){
		return "Método limpar da classe bicicleta";
	}

}
