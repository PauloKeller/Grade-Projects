package modelo;

import java.util.Scanner;

public class Empregado extends Pessoa{
	
	protected int codigoSetor;
	protected float salarioBase;
	protected double imposto;
	
	public int getCodigoSetor() {
		return codigoSetor;
	}
	public void setCodigoSetor(int codigoSetor) {
		this.codigoSetor = codigoSetor;
	}
	public float getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}
	public double getImposto() {
		return imposto;
	}
	public void setImposto(float imposto) {
		this.imposto = imposto;
	}
	
	public double calcularSalario()
	{
		double salario;
		
		salario = salarioBase - (salarioBase*(imposto/100));
		
		return salario;
	}
	public static void defineEmpregado()
	{
		Empregado e1 = new Empregado();
		Scanner leitor = new Scanner(System.in);
		
		System.out.printf("\n+++++++++++EMPREGADO+++++++++++\n");
		System.out.print("Digite o nome do empregado:");
		e1.setNome(leitor.next());
		System.out.print("Digite o endereço do empregado:");
		e1.setEndereco(leitor.next());
		System.out.print("Digite o telefono do empregado:");
		e1.setTelefone(leitor.next());
		System.out.print("Digite o codigo de setor do empregado:");
		e1.setCodigoSetor(leitor.nextInt());
		System.out.print("Digite o salario base do empregado:");
		e1.setSalarioBase(leitor.nextFloat());
		System.out.print("Digite o valor do imposto sobre o salario:");
		e1.setImposto(leitor.nextFloat());
		System.out.printf("Salario do empregado: %.2f", e1.calcularSalario());
	}

}
