package mytuil;

public class MealCard {

	public String aluno;
	public int saldo;
	int salgado;
	int sobremesa;
	int almoco;
	int jantar;
	int sorvete;

	public MealCard(String nome, int saldo) {

		this.aluno = nome;

		if (saldo == 0) {
			this.saldo = 100;
		} else {
			this.saldo = saldo;
		}

		this.aluno = nome;

	}

	public String getAluno() {
		return aluno;
	}
	
	public int getSaldo(){
		return saldo;
	}

	public  int fazerCompra(int opcao) {
		 
		switch (opcao) {
		case 1:
			saldo = saldo - Cardapio.SALGADO.getValor();
			System.out.printf("%d",saldo);
			break;
		case 2:
			saldo = saldo - Cardapio.SOBREMESA.getValor();
			break;
		case 3:
			saldo = saldo - Cardapio.ALMOCO.getValor();
			break;
		case 4:
			saldo = saldo - Cardapio.JANTAR.getValor();
			break;
		case 5:
			saldo = saldo - Cardapio.SORVETE.getValor();
			break;
		case 0:
			break;
		}
		return saldo;
	}
}