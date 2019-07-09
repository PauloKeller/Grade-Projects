package modelo;

import java.util.Scanner;

public class Administrador extends Empregado{
	
	protected float ajudaDeCusto;

	public float getAjudaDeCusto() {
		return ajudaDeCusto;
	}

	public void setAjudaDeCusto(float ajudaDeCusto) {
		this.ajudaDeCusto = ajudaDeCusto;
	}
	
	public double calcularSalario()
	{
		double salario;
		
		salario = salarioBase - (salarioBase*(imposto/100));
		return salario+ajudaDeCusto;
	}
	
	public static void defineAdministrador()
	{
		Administrador adm1 = new Administrador();
		Scanner leitor = new Scanner(System.in);
		
		System.out.printf("\n+++++++++++ADMINISTRADOR+++++++++++\n");
		System.out.print("Digite o nome do administrador:");
		adm1.setNome(leitor.next());
		System.out.print("Digite o endereço do administrador:");
		adm1.setEndereco(leitor.next());
		System.out.print("Digite o telefone do administrador:");
		adm1.setTelefone(leitor.next());
		System.out.print("Digite o codigo de setor do administrador:");
		adm1.setCodigoSetor(leitor.nextInt());
		System.out.print("Digite o salario base do administrador:");
		adm1.setSalarioBase(leitor.nextFloat());
		System.out.print("Digite o valor do imposto sobre o administrador:");
		adm1.setImposto(leitor.nextFloat());
		System.out.print("Digite a ajuda de custo do administrador:");
		adm1.setAjudaDeCusto(leitor.nextFloat());
		System.out.printf("Salario do empregado: %.2f", adm1.calcularSalario());
	}
}
