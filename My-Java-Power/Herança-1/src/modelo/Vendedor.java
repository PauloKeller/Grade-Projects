package modelo;

import java.util.Scanner;

public class Vendedor extends Empregado {
	
	protected float valorVendas;
	protected float comissao;
	
	public float getValorVendas() {
		return valorVendas;
	}
	public void setValorVendas(float valorVendas) {
		this.valorVendas = valorVendas;
	}
	public float getComissao() {
		return comissao;
	}
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	
	public double calcularSalario()
	{
		double salario;
		double com;
		
		com = valorVendas*(comissao/100);
		salario = salarioBase - (salarioBase*(imposto/100));
		
		
		return salario + com;
	}
	
	public static void defineVendedor()
	{
		Vendedor vnd1 = new Vendedor();
		Scanner leitor = new Scanner(System.in);
		
		System.out.printf("\n+++++++++++VENDEDOR+++++++++++\n");
		System.out.print("Digite o nome do vendedor:");
		vnd1.setNome(leitor.next());
		System.out.print("Digite o endereço do vendedor:");
		vnd1.setEndereco(leitor.next());
		System.out.print("Digite o telefone do vendedor:");
		vnd1.setTelefone(leitor.next());
		System.out.print("Digite o codigo de setor do vendedor:");
		vnd1.setCodigoSetor(leitor.nextInt());
		System.out.print("Digite o salario base do vendedor:");
		vnd1.setSalarioBase(leitor.nextFloat());
		System.out.print("Digite o valor do imposto sobre o salario:");
		vnd1.setImposto(leitor.nextFloat());
		System.out.print("Digite o valor de vendas do vendedor:");
		vnd1.setValorVendas(leitor.nextFloat());
		System.out.print("Digite o valor da comissao do vendedor:");
		vnd1.setComissao(leitor.nextFloat());
		System.out.printf("Salario do vendedor: %.2f", vnd1.calcularSalario());
	}
}
