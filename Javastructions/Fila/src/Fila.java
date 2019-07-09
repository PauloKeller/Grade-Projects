public class Fila {
	private int[] vetor;
	private int  total;
	private int inicio;
	
	Fila(){
		vetor = new int[5];
		inicio = 0;
		total = 0;
	}
	
	public boolean isVazia(){
		return total == 0;
	}
	
	public boolean isCheia(){
		return total == vetor.length;
	}
	
	public void inserir(int valor){
		if(isCheia()){
			System.out.println("Fila cheia");
		} else {
			int fim = (inicio + total) % vetor.length;
			vetor[fim] = valor;
			total++;
		}
	}
	
	public int remover(){
		if(isVazia()){
			System.out.println("Fila vazia");
			return -1;
		} else {
			int valor = vetor[inicio];
			inicio = (inicio + 1) % vetor.length;
			total--;
			return valor;
		}
	}
	
	public void limpar(){
		inicio = 0;
		total = 0;
	}
	
	public void imprimir(){
		if(isVazia()){
			System.out.println("Fila vazia");
		} else {
			int posicao = inicio;
			for (int i = 0; i < total; i++) { 
				posicao = posicao % vetor.length;
				System.out.println(vetor[posicao] + " ");
				posicao++;
			}
			System.out.println();
		}
	}

}
