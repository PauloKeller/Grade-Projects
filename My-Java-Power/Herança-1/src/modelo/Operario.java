package modelo;

import java.util.Scanner;

public class Operario extends Empregado {
	
	protected float valorProducao;
	protected float comissao;
	
	public float getValorProducao() {
		return valorProducao;
	}
	public void setValorProducao(float valorProducao) {
		this.valorProducao = valorProducao;
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
		
		com = valorProducao*(comissao/100);
		salario = salarioBase - (salarioBase*(imposto/100));
		
		
		return salario + com;
	}
	
	public static void defineOperario()
	{
		Operario op1 = new Operario();
		Scanner leitor = new Scanner(System.in);
		
		System.out.printf("\n+++++++++++OPERARIO+++++++++++\n");
		System.out.print("Digite o nome do operario:");
		op1.setNome(leitor.next());
		System.out.print("Digite o endereço do operario:");
		op1.setEndereco(leitor.next());
		System.out.print("Digite o telefone do operario:");
		op1.setTelefone(leitor.next());
		System.out.print("Digite o codigo de setor do operario:");
		op1.setCodigoSetor(leitor.nextInt());
		System.out.print("Digite o salario base do operario:");
		op1.setSalarioBase(leitor.nextFloat());
		System.out.print("Digite o valor do imposto sobre o salario:");
		op1.setImposto(leitor.nextFloat());
		System.out.print("Digite o valor de produção do operario:");
		op1.setValorProducao(leitor.nextFloat());
		System.out.print("Digite o valor da comissao do operario:");
		op1.setComissao(leitor.nextFloat());
		System.out.printf("Salario do operario: %.2f", op1.calcularSalario());
	}

}
