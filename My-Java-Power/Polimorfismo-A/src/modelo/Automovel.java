package modelo;

public class Automovel implements Veiculo {
	
	@Override
	public String listaVerificacoes(){
		return "Método lista verificaçoes da calsse automovel";
	}
	
	@Override
	public String limpar(){
		return "Método limpar da classe automovel";
	}
	
	@Override
	public String ajustar(){
		return "Método ajustar da classe automovel";
	}
	
	public String trocarOleo(){
		return "Método trocar oleo da classe automovel";
	}

}
