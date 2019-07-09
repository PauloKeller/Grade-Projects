package view;
import java.util.*;
import control.*;
public class Main {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		double taxa_de_juros;
		int periodo_de_emprestimo;
		double valor_do_emprestimo;
		
		System.out.print("Digite o valor do emprestimo:");
		valor_do_emprestimo = leitor.nextFloat();
		
		System.out.print("Digite o periodo do emprestimo em meses:");
		periodo_de_emprestimo = leitor.nextInt();
		
		System.out.print("Digite a taxa de juros anual:");
		taxa_de_juros = leitor.nextFloat();
		
		Calculadora_Emprestimos emprestimo1 = new Calculadora_Emprestimos();
		
		emprestimo1.calcularPagamentos(taxa_de_juros, valor_do_emprestimo, periodo_de_emprestimo);
		
		System.out.printf("Mensalidade: %f Total: %f", emprestimo1.mensalidade, emprestimo1.saldo );
	}

}
