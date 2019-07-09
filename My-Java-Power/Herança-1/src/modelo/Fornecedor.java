package modelo;

import java.util.Scanner;

public class Fornecedor extends Pessoa{
	
	protected float valorCredito;
	protected float valorDivida;
	
	public float getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(float valorCredito) {
		this.valorCredito = valorCredito;
	}

	public float getValorDivida() {
		return valorDivida;
	}

	public void setValorDivida(float valorDivida) {
		this.valorDivida = valorDivida;
	}
	
	public float obterSaldor()
	{
		float saldo;
		saldo = valorCredito - valorDivida;
		return saldo;
		
	}
	
	public static void defineFornecedor(){
	Fornecedor f1 = new Fornecedor();
	Scanner leitor = new Scanner(System.in);
	System.out.println("+++++++++++FORNECEDOR+++++++++++");
	System.out.print("Digite o nome do fornecedor:");
	f1.setNome(leitor.next());
	System.out.print("Digite o endereço do fornecedor:");
	f1.setEndereco(leitor.next());
	System.out.print("Digite o telefone do fornecedor:");
	f1.setTelefone(leitor.next());
	System.out.print("Didigite o valor do credito:");
	f1.setValorCredito(leitor.nextFloat());  
	System.out.print("Digite o valor da divida:");
	f1.setValorDivida(leitor.nextFloat());
	System.out.printf("Saldo: %.2f", f1.obterSaldor());
	}
}


