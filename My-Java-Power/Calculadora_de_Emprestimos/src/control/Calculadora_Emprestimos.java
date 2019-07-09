package control;

public class Calculadora_Emprestimos {
	public double saldo;
	double taxa_de_juros;
	int periodo_de_emprestimo;
	public double mensalidade;
	double valor_do_emprestimo;
	
	public void calcularPagamentos(double taxa_de_juros, double valor_do_emprestimo, int periodo_de_emprestimo){
		double pagamento_mensal;
		double total;
		
		total = valor_do_emprestimo + (valor_do_emprestimo * (taxa_de_juros/100));
		pagamento_mensal = total / periodo_de_emprestimo;
		
		this.mensalidade = pagamento_mensal;
		this.saldo = total;
	}
}
