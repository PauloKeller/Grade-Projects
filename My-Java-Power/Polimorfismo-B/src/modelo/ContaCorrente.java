package modelo;

public class ContaCorrente extends Conta{
	
	@Override
	public void atualizar(double taxa){
		this.saldo += this.saldo*taxa*2;
	}
	
	@Override
	public void deposita(double valor){
		this.saldo += valor -0.10;
	}

}
