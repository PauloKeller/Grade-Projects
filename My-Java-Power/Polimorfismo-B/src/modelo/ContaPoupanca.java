package modelo;

public class ContaPoupanca extends Conta{
	
	@Override
	public	void atualizar(double taxa){
		this.saldo += this.saldo*taxa*3;
	}

}
