package modelo;

public class AtualizadorDeContas {
	
	private double saldoTotal = 0;
	private double selic;
	
	AtualizadorDeContas(double selic){
		this.selic = selic;
	}
	
	void roda(Conta c){
		this.saldoTotal = c;
	}
	
	
}
